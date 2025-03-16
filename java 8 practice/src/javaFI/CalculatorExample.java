package javaFI;

interface Calculator{
    void switchOn();
}

interface  Calculator2 {
    void switchOn2();
}

interface Cal3{
    void switchOn3();
}

public class CalculatorExample implements Calculator {

    //traditonal approach
    @Override
    public void switchOn() {
        System.out.println("Switching on the calculator 1");
    }

    // lamda expression () -> {}j
Calculator2 cal2=    () -> {System.out.println(" 2md on");};


    Cal3 cal3 = () -> System.out.println("cal3");


    public static void main(String[] args){
        CalculatorExample cal1 = new CalculatorExample();
        cal1.switchOn();
        cal1.cal2.switchOn2();
    }


}
