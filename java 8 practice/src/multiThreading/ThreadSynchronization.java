package multiThreading;


class SychThreadEXample{
//    int count;
int count;
    public synchronized void display(){
        count++;
    }

}
public class ThreadSynchronization {
    public static void main(String[] args) throws InterruptedException {
        SychThreadEXample sychThreadEXample = new SychThreadEXample();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 1001; i++) {
                sychThreadEXample.display();
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 1001; i++) {
                sychThreadEXample.display();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(sychThreadEXample.count);

    }

}
