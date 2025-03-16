package javaFI.corejava;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDuplicate {

    public static void main(String[] args){

        //find the duplicate
        String str = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";

        List<String> list = List.of(str.split(" "));

     Map<String,Long> countmap = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

     System.out.println(countmap);


        countmap.entrySet().stream().filter(s->s.getValue()>1).forEach(s->System.out.println(s.getKey()+" :"+s.getValue()));

        String result = list.stream().max(Comparator.comparing(String::length))
                .get();
        System.out.println("String logest is :"+result);

//        System.out.println(list+"\n\n");

        Map<String , Integer> map = new HashMap<>();
        for(String s:list){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(Map.Entry<String,Integer> i:map.entrySet()){
            if(i.getValue()>1){
                System.out.println(i.getKey()+":"+i.getValue());
            }
        }


        //find the same string
        List<String> list1= Arrays.asList("sachin","rahul","saurav","laxman");
        List<String> list2=Arrays.asList("mayank","zaheer","sachin","yuvraj");
        for(String i:list1){
            for(String j:list2){
                if(i.equals(j)){
                    System.out.println(i);
                }
            }
        }

        //calculate the sum of the elements

        List<Integer> list3 = Arrays.asList(1,29,10,2,65);

        Optional<Integer> sum = list3.stream().reduce((a, b)->a+b);

        System.out.println("\nsum is :"+sum.get());

        //calculate the min and max

  Optional<Integer> min= list3.stream().reduce((a,b)->a<b?a:b);
   Optional<Integer> max =   list3.stream().reduce((a,b)->a>b?a:b);
        System.out.println("\n min is :"+min+" mand max is :"+max);

        //calculate the average of numbers

    double avg=  list3.stream().mapToInt(e->e).average().getAsDouble();

    System.out.println(" average is :"+avg+"" +
            "\n");

    //square of the number
        double sqauareavg =
        list3.stream()
                .map(e->e*e)
                .filter(e->e>10)
                .mapToInt(e->e)
                .average()
                .getAsDouble();

        System.out.println(" square avr is "+sqauareavg);


    }
}
