package javaFI.java8interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicate {
    public static void main(String[] args){
        //find the duplicate
        String str = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";



        Map<String,Long> map = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        map.entrySet().stream().filter(s->s.getValue()>2).forEach(s->System.out.println(s.getKey()+":"+s.getValue()));

        //find the same string
        List<String> list1= Arrays.asList("sachin","rahul","saurav","laxman");
        List<String> list2=Arrays.asList("mayank","zaheer","sachin","yuvraj");

        for(String i : list1){
            for(String j: list2){
                if(i.equals(j)){
                    System.out.println(i);
                }
            }
        }
    }
}
