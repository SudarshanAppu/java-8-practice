package febPratice;

import java.util.concurrent.*;

class MyRunnable implements  Runnable{

    @Override
    public void run() {
        int n=5;
        int fact = 1;
        for(int i =1;i<=5;i++){
            fact *=i;//fact = fact*n;
        }
        System.out.println("Factorial from run():"+fact);
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for(int i =1;i<=5;i++){
            fact *=i;//fact = fact*n;
        }
//        System.out.println("Factorial from run()"+fact);
        return fact;
    }
}


public class CollablevsRunnable {
    public  static  void main(String[] args) throws ExecutionException, InterruptedException {
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        t1.start();

        MyCallable callable = new MyCallable();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> res =executor.submit(callable);
        executor.submit(runnable);


        System.out.println(" factorial from call()"+res.get());
        executor.shutdown();
    }
}
