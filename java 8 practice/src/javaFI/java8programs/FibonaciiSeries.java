package javaFI.java8programs;

class Fibonacii{
    public static void fibo(int count){
        int n1=0;
        int n2=1;
        System.out.print("Fibo series is :"+n1+" "+n2);

        for(int i = 2 ;i< count ;i++){
            int n3 = n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }


    }
}
public class FibonaciiSeries {

    public static void main(String args[]){
        Fibonacii.fibo(10);
    }

}
