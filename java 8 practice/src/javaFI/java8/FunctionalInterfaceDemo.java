package javaFI.java8;

import java.lang.annotation.Annotation;

interface FunctionalInterfaceDemo1{
     void switchOn();
     void SwitchOff();

}

class DemoInterface implements FunctionalInterfaceDemo1{
    @Override
    public void switchOn() {
        System.out.println("Switching on");

    }

    @Override
    public void SwitchOff() {
        System.out.println("Switching off");

    }


}

@FunctionalInterface
interface  InterfaceFunctional  {

    void switchOn();
//    void Switchoff();
        }

public class FunctionalInterfaceDemo {

    InterfaceFunctional interfaceFunctional = ()->{System.out.println("Switch on from functional interface");}; //general way of calling
    InterfaceFunctional interfaceFunctional1 = ()->System.out.println("modified way of calling switch on reducing code");

    public static void main(String[] args){
        DemoInterface demoInterface  = new DemoInterface();
        demoInterface.switchOn();
        demoInterface.SwitchOff();

        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo();
        functionalInterfaceDemo.interfaceFunctional.switchOn();
        functionalInterfaceDemo.interfaceFunctional1.switchOn();

    }

}



