//package multiThreading;
//
//import java.util.*;
//
//class ListData {
//
//    static int count;
//    public static synchronized void display(){
//                count++;
//    }
//
//    int count1;
//    public synchronized void setCount(int count){
//        count1 = count;
//    }
//
//    public synchronized int getCount(){
//        return count1;
//    }
//}
//
//
//public class MyThreadExample {
//    public static void main(String[] args) throws InterruptedException {
//
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                Thread t1 = new Thread();
//                t1.setName("runnable1");
//                for (int i = 1; i < 11; i++) {
//
//                    System.out.println(t1.getName() + ":" + i);
//                    ListData.display();
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        };
//
//
//
//        Producer1 producer1 = new Producer1(lIstData);
//        Consumer1 consumer1 = new Consumer1(lIstData);
//
//        Thread t3 = new Thread(producer1);
//        Thread t4 = new Thread(consumer1);
//
////t3.start();
////t4.start();
//
//
//    }
//
//    class Producer1 implements Runnable {
//
//        ListData listData;
//        Thread t9 = new Thread();
//
//        public Producer1(ListData listData) {
//            this.listData = listData;
//            t9.setName("producer1");
//            t9.start();
//
//        }
//
//        @Override
//        public void run() {
//            for (int i = 1; i <= 10; i++) {
//                System.out.println(t9.getName() + ": " + i);
//                listData.setCount(i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
//
//    class Consumer1 implements Runnable {
//        ListData listData;
//        Thread t10 = new Thread();
//
//        public Consumer1(ListData listData) {
//            this.listData = listData;
//            t10.setName("consumer1");
//
//            t10.start();
//        }
//
//        @Override
//        public void run() {
//            for (int i = 1; i <= 10; i++) {
//                System.out.println(t10.getName() + " " + listData.getCount());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
////            listData.setCount(i);
//            }
//
//        }
//    }
//}
