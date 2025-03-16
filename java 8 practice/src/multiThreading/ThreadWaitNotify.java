package multiThreading;

class Q{    int count;
    boolean value = false;
    public synchronized void setCount(int count) throws InterruptedException {
        if(value)
        {
         wait();
        }
        this.count = count;
        value= true;
        notify();
    }
    public synchronized int getCount() throws InterruptedException {
        if(!value){
            wait();
        }
        value=false;
        notify();
        return count;

    }
}
class Producer implements Runnable{
    Q q = new Q();
    Thread t1 = new Thread();

    public Producer(Q q) {
        this.q = q;
        t1.setName("Producer");
        t1.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(t1.getName()+" : "+i);
            try {
                q.setCount(i);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class  Consumer implements  Runnable{
Q q = new Q();
    Thread t1 = new Thread();

    public Consumer(Q q) {
        this.q = q;
        t1.setName("Consumer");
        t1.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {

            try {
                System.out.println(t1.getName()+" : "+q.getCount());

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadWaitNotify {
public static void main(String []args){

    Q q = new Q();
    Consumer consumer = new Consumer(q);
    Producer producer = new Producer(q);

    Thread t1 = new Thread(producer);
    Thread t2 = new Thread(consumer);

    t1.start();
    t2.start();

}

}
