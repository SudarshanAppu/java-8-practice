package javaFI;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ConsumerAcceptDemo {
    public  static void main(String[] args) {
        //consumer accept method
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        list1.stream().forEach(t->System.out.println("print " +t));

        //predicate
        list1.stream().filter(t-> t%2==0).forEach(t->System.out.println(" evne number is " +t));

        //supplier

        List<String> list2 = Arrays.asList();
//Supplier<String> supplier =()-> "no elements found";
        System.out.println(list2.stream().findAny().orElseGet(()-> "no elements found"));

//        stream api pipeline methods foreach and filter
//                for each method for iteration

        //for each method list and map example

        List<Integer> list3 = new ArrayList<>();

        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);

        list3.stream().forEach(t-> System.out.println(t));

        //but map has  no steam() func to iterate from it
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"a");
        map1.put(2,"b");
        map1.put(3,"c");
        map1.put(4,"d");

        map1.forEach((key,value)-> System.out.println("key :"+key+", value :"+value));

        //we need to provide entryset to map to use stream()

        map1.entrySet().forEach(t->System.out.println(t));

        //example of filter and foreach method both map and list example

        List<String> list4 = new ArrayList<>();
        list4.add("abc");
        list4.add("abd");
        list4.add("cba");

        list4.stream().filter(t->t.startsWith("a")).forEach(t->System.out.println(t));

        Map<Integer,String> map2= new HashMap<>();

        map2.put(1,"a");
        map2.put(2,"ab");
        map2.put(3,"cd");

        map2.entrySet().stream().filter(t->t.getValue().startsWith("a")).forEach(t->System.out.println("\n"+t));


    }



}
