package javaFI.corejava;

class A{
     void test(String s){System.out.println("String s");}
    void test(Object s){System.out.println("String s");}
    void test(StringBuffer sb){System.out.println("StringBUffer sb");}
    void test(Integer i){System.out.println("Integer i");}
}

class A1{
    void test(String s){System.out.println("String s");}
    void test(Object o){System.out.println("Object o");}
//    void test(StringBuffer s){System.out.println("String s");}
}
class A2{
    void test(String s){System.out.println("String s");}
    void test(Object o){System.out.println("Object o");}
//    void test(StringBuffer sb){System.out.println("StringBUffer sb");}
    void test(Integer i){System.out.println("Integer i");}
}

class A3{
    void test(String s, Object o){System.out.println("String s and object o");}
    void test(Object o, String s){System.out.println("object o and String s");}
    void test(StringBuffer sb, Integer i){System.out.println("StringBUffer sb and Integer i");}
//    void test(Integer i){System.out.println("Integer i");}
}

class A4{
//    void test(String s, Object o){System.out.println("String s and object o");}
    void test(Object o, String s){System.out.println("object o and String s");}
    void test(char[] cr, Integer i){System.out.println("Char[] array cr and Integer i");}
    void test(Integer i,Object o){System.out.println("Integer i and Object o");}
}

class A5{
    //    void test(String s, Object o){System.out.println("String s and object o");}
    static void test(Object o, String s){System.out.println("object o and String s");}
    void test(char[] cr, Integer i){System.out.println("Char[] array cr and Integer i");}
    void test(Integer i,Object o){System.out.println("Integer i and Object o");}
}

public class MethodOverLoading {
    public static void main(String args[]) {

        System.out.println(" A5 class Sting integer and object combo");
        A5 a5 = new A5();

//        a5.test(1, null);//ambiguity

        A a = new A();
//       a.test(null); // Ambiguous method call. Both String and StringBuffer from same level
//        a.test(null);

        A1 a1 = new A1();
        a1.test(null); // String S : because  String is a subclass of Object and has more significate match
        a1.test(new Object());// Object class is significate match in this scenario

        A2 a2 = new A2();
//        a2.test(null);  // ambiguilty between String and integer
        System.out.println(" A2 class Sting integer and object combo");
        a2.test(1);
        a2.test("hi");
        a2.test(new Object());
        System.out.println(" A3 class Sting integer and object combo");

        A3 a3 = new A3();
//        a3.test(null,null); ambiguity between String oject and object String
        a3.test("hi", new Object());// String and object
        a3.test(null, new Object());//String and Object
//        a3.test(null, 1); ambiguity String object and String buffer Integer
        a3.test("hi", new Object());//String and object
        a3.test("hi",1);//String and Integer
        System.out.println(" A4 class Sting integer and object combo");

        A4 a4 = new A4();
        a4.test(null,new Object());
//        a4.test(null,1);// ambiguity btw Integer and Char
        a4.test(1,new Object());




    }
}
