package coreJava;

public class StaticVsNonStatic {

        static int number;
        static  {
            System.out.println("static block");
            number=5;
        }
    {
        System.out.println("non static block");
    }

    public StaticVsNonStatic(){
        System.out.println("Constructor");
    }
    public static void main(String [] args){
//
//        System.out.println(" main method :"+StaticVsNonStatic.number);
//
        StaticVsNonStatic s1 = new StaticVsNonStatic();
        s1.number = 007;
        System.out.println(" after constructor creation: "+StaticVsNonStatic.number);
        new StaticVsNonStatic().print();

/*
        StaticVsNonStatic staticVsNonStatic = new StaticVsNonStatic();
        System.out.println(staticVsNonStatic.number);
        staticVsNonStatic.number=5;
        System.out.println(staticVsNonStatic.number);

        staticVsNonStatic.number= 8;
        System.out.println(StaticVsNonStatic.number);

        StaticVsNonStatic s2 = new StaticVsNonStatic();

        System.out.println(s2.number);*/

                    }

                    public  void print(){
                        System.out.println("print methhod execution");
//                        main(new String[]{"abc","abc"});
                        print2();
                    }
                    public void print2(){
                        System.out.println("print 2 method execution");
                    }
}

 class overloading{

    void m1(int str){
        System.out.println(" m1 int");
    }

    void m1(float in){

    }

     public static void main(String[] args) {
         overloading overloading = new overloading();
     overloading.m1(1f);
     }
}
