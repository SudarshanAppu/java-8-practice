package CompletableFutureExample;

import org.w3c.dom.CDATASection;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class DatabaseStudent{
    public static List<Student> database(){
        List<Student> list = new ArrayList<>();
        for(int i = 0;i<1001;i++){
            list.add(new Student(i,"name"+i));
        }
        return list;
    }

}

public class DemoCompletableFuture {
    public static Void studentListcheck() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(" The Thread name:"+Thread.currentThread().getName());// it uses forkjoinpool commonpool -worker n thread
            List<Student> studentList = DatabaseStudent.database();
            System.out.println(studentList.size());
        });

        return  completableFuture.get();
    }

    // with executorservice custom thread pool
    public static  Void studentListCheckwithExecutors() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            List<Student> list = DatabaseStudent.database();
            System.out.println("Thread name :"+Thread.currentThread().getName());// takes custom thread pool and among any threads between 1 to 5
            System.out.println(list.size());

        }, executorService);

        return completableFuture.get();
    }

    // supply asynch which expects some response

    public static List<Student> studentListwithSupplAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<List<Student>> completableFuture = CompletableFuture.supplyAsync(()->
        {
            List<Student> list = DatabaseStudent.database();
            System.out.println(" supply async Thread name "+Thread.currentThread().getName());
            return list;
        });
        return  completableFuture.get();
    }

    public static List<Student> studentListwithSupplyAsyncExecutors() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<List<Student>> completableFuture = CompletableFuture
                .supplyAsync(()->{
                    var listStudent = DatabaseStudent.database();
                    System.out.println("Supply Async executors Thread is :"+Thread.currentThread().getName());
                    return  listStudent;
                }, executorService);
        return  completableFuture.get();
    }


    public static void main(String []args) throws ExecutionException, InterruptedException {
        System.out.println(" at beginning of main Thread name is: "+Thread.currentThread().getName());
        DemoCompletableFuture demoCompletableFuture = new DemoCompletableFuture();
        DemoCompletableFuture.studentListcheck();
        DemoCompletableFuture.studentListCheckwithExecutors();
        System.out.println(DemoCompletableFuture.studentListwithSupplAsync().size());
        System.out.println(DemoCompletableFuture.studentListwithSupplyAsyncExecutors().size());
        System.out.println(" at end of main Thread name is :"+Thread.currentThread().getName());

        Thread thread1 = new Thread(()->{

            System.out.println("new Thread name is : "+Thread.currentThread().getName());
            for(int i = 0; i<11;i++){
                System.out.println(Thread.currentThread().getName()+": "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        thread1.setName("Thread1");
        thread1.start();

        Runnable runnable1  = ()->{
            System.out.println(" new runnable "+Thread.currentThread().getName());
            for(int i = 0; i<11;i++){
                System.out.println(Thread.currentThread().getName()+": "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        Thread thread2 = new Thread(runnable1);
        thread2.setName("Thread2");
        thread2.start();


    }
}
