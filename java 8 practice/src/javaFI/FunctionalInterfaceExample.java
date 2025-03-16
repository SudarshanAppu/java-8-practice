package javaFI;

@FunctionalInterface
public interface FunctionalInterfaceExample {
    void m1();

    default void m2(int i){
        System.out.println("FI demo");
    }

    static void m3(int j){
        System.out.println(" Fi demo static method");
    }

//    void m4();//gives error
}
