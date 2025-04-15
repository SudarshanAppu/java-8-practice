package CompletableFutureExample;


import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMarch22 {
    public static List<Student1> database() {
        List<Student1> list = new ArrayList<>();
       for(int i = 0;i<1001;i++){
           list.add(new Student1(1,"name"+i));

       }
       return  list;
    }

    public static Void CompletableRunSync() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            List<Student1> list1 = new ArrayList<>();

            list1 = CompletableFutureMarch22.database();
            System.out.println(" The runasync using is "+Thread.currentThread().getName());
            System.out.println("size of list is :"+ list1.size());

        }, executorService);
        return completableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureMarch22.CompletableRunSync();

    }
}
class Student1{
    int id;
    String name;

    public Student1(int id, String name) {
        this.id = id;
        this.name = name;
    }
}