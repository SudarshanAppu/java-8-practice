package multiThreading;
class Listdata {
    int count = 0 ;
    public void display(){
        System.out.println(count);
    }
    public void setCount(){
        count++;
    }
    public int getCount(){
        return count;
    }
}

public class March11Multi {
    public static void main(String [] args) throws InterruptedException {
        Listdata listdata = new Listdata();
        Thread t1 = new Thread(()->
        {
           for(int i = 0; i<11;i++) {

               System.out.println(Thread.currentThread().getName()+":"+i);
               listdata.setCount();
               listdata.display();
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
        });
        t1.start();
        Runnable runnable = ()->{
            for(int i =0;i<11;i++){
                System.out.println(Thread.currentThread().getName()+":"+listdata.getCount());
                listdata.display();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        Thread t2 = new Thread(runnable);
        t2.start();
        Thread.sleep(1000);
    }
}
