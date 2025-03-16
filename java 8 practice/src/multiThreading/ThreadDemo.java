package multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Thread1 extends Thread{
    public void run(){
        for( int i =0;i<6;i++){
            System.out.println("Hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

class Thread2 extends Thread{
    public void run(){
        for( int i =0;i<6;i++){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class ThreadList{
    public static List<Integer> listMethod() {
        List<Integer>  list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {

            list.add(i);
        }

        return  list;
    }
}

public class ThreadDemo {
    public  static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        t1.start();
        Thread.sleep(100);
        t2.start();

        t1.join();
        t2.join();
        Runnable runnable1 = ()->ThreadList.listMethod().stream().forEach(s-> {
            try {
                System.out.println(s);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Runnable runnable2 = () -> ThreadList.listMethod().stream().forEach(s-> {
            try {
                System.out.println(s);
                        Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread runt1 = new Thread(runnable1);
        runt1.start();
        Thread.sleep(100);
        Thread runt2 = new Thread(runnable2);
        runt2.setDaemon(true);
        runt2.start();
        System.out.println(t2.isAlive());
        System.out.println(t2.getPriority());
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t1.getPriority());

    }
}
