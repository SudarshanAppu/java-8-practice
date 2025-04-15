package marchpratice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class March25Pratice {
    public static void main(String[] args) {
        //problem statment find the day when stock is minimum to buy stock & find the day when stack is max to sell
        // out put : day 2 & day 7
        List<Integer> list = Arrays.asList(3, 1, 6, 8,2,6,10);

        System.out.println(list.stream());
        Optional<Integer> min =list.stream().reduce((a,b)->a<b?list.indexOf(a):list.indexOf(b));
        Optional<Integer> max = list.stream().reduce((a,b)->a>b?list.indexOf(a):list.indexOf(b));

        System.out.println(" day "+(min.get()+1)+"& day"+(max.get()+1));

        String inputString = "Java Concept Of The Day".replaceAll("\\s+", "");

        //find first non repeating character

        Arrays.stream(inputString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()<2)

                .forEach(System.out::println);
          var         firstNonRepeat =
                 Arrays.stream(inputString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new , Collectors.counting()))
                         .entrySet().stream().findFirst().get();

        System.out.println("first no repeat"+ firstNonRepeat);

        Optional<String> firstunique = Arrays.stream(inputString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().map(Map.Entry::getKey).findFirst();

        System.out.println("first non repeat only char: "+firstunique.get());

        List<String> listip = Arrays.asList("10.0.0.1", "10.0.0.2", "10.0.0.2", "10.0.0.2");

        Optional<Map.Entry<String, Long>> resmap = listip.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        System.out.println(resmap.get());
//                .stream().map(Map.Entry::getKey)
//                .forEach(System.out::println);

        listip.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .stream().map(Map.Entry::getKey).forEach(System.out::println);

        List<String> stringList = Arrays.asList("st12","str134","str4567");

                //print longest string in a list
        stringList.stream().max(Comparator.comparing(String::length))
                .stream().forEach(x -> System.out.println("longest string is :"+x));
        //print smallest string in string list
        stringList.stream().min(Comparator.comparing(String::length))
                .stream().forEach(e-> System.out.println("smallest string is : "+e));


        //print duplicate except space that is
        System.out.println("print dups without space ");
        String inputString1 = "Java Concept Of The Day";
        Arrays.stream(inputString1.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->(!e.getKey().contains(" ")&&e.getValue()>=2))
                .forEach(System.out::println);

        //print max duplicate except space

        System.out.println("only max repeated char is ");
        Arrays.stream(inputString1.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->(!e.getKey().contains(" ")))
                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);

        Arrays.stream(inputString1.toLowerCase().repeat(2).split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->(!e.getKey().contains(" ")))
                .max(Map.Entry.comparingByValue())
                .stream().forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(3, 1, 6, 8,2,6,10);
  int[] intArray = {3, 1, 6, 8,2,6,10};
        //find min max avg and sum

        int minelement =list1.stream().min(Comparator.naturalOrder()).get();
        System.out.println("min element is :"+minelement);
        int   minelement2 =Arrays.stream(intArray).min().getAsInt();
        System.out.println("another min element from array is: "+minelement2);

        int suofListints = list1.stream().mapToInt(e->e)
                .sum();
               int sumofints =  Arrays.stream(intArray).sum();
        System.out.println(" sum of list ints is : "+suofListints);
        System.out.println();

    }
}
