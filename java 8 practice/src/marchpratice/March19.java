package marchpratice;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import java.util.List;
public class March19 {
    public static void main(String[] args){
        //find age when dob is given

        LocalDate birthday = LocalDate.of(1996,01,23);
        LocalDate today = LocalDate.now();
        System.out.println("local date .now ()"+today);
        long age = ChronoUnit.YEARS.between(birthday,today);

        System.out.println(" actula age is "+age);



//        LocalDate birthDay = LocalDate.of(1985, 01, 23);
//        LocalDate today = LocalDate.now();

//        System.out.println(ChronoUnit.YEARS.between(birthDay, today));


        //how do i get last element of an array

        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");

        String last = listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
        System.out.println("last element is "+last);

        // group wiht first char of the string and store it inside[]
        listOfStrings.stream().collect(Collectors.groupingBy(e->e.charAt(0),
                Collectors.joining(",","[","]")))
                .entrySet().stream().forEach(System.out::println);

        //group with first char of the string and join it like if 'a' then appple_aap

        listOfStrings.stream().collect(Collectors.groupingBy(e->e.charAt(0)
                ,Collectors.joining("_")))
                .entrySet().stream().forEach(System.out::println);

        //Find first non-repeated character in a string?  that is if we dont use linked hashmap
        // the order is not specified without using linked hashmap
        String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        Map.Entry<String, Long> stringLongEntry = Arrays.stream(String.valueOf(inputString).split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .get();

        //so output may be of unexpected
        System.out.println(stringLongEntry);

        // write same thing with using linked hashmap
        Map.Entry<String, Long> stringLongEntry1 = Arrays.stream(inputString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .limit(1).findFirst().get();

        System.out.println(stringLongEntry1);

        // sort the list in ascending order

        System.out.println(" SORTING ");
        List<Integer> numbers = Arrays.asList(3, 5, 1, 7, 2);

        numbers.stream().sorted().forEach(System.out::print);
        System.out.println(" SORTING IN REVERSE ORDER");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);


        //sorting array of element ascending and decsending

        System.out.println(" \nArray sorting ");
        int[] arr = {3, 5, 1, 7, 2};
        Arrays.stream(arr).sorted().forEach(System.out::print);
        System.out.println("\nArrays reverse order sorting is:");
        int[] arr2 =Arrays.stream(arr).sorted().toArray();
        System.out.println(" before reversing");
        for(int i =0;i<arr2.length;i++){
            System.out.print(arr2[i]);
        }
        System.out.println(" after reversing");
        IntStream.rangeClosed(1,arr2.length).map(e->arr2[arr2.length-e])
                .forEach(System.out::print);


        //converting array to list integers and reversing it

        List<Integer> list = Arrays.asList(3, 5, 1, 7, 2);
        System.out.println("list array desceding");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 35)
        );

        var result = people.stream().collect(Collectors.groupingBy(Person::getAge));

        for(Map.Entry<Integer,List<Person>> i:result.entrySet()){
            if(i.getValue().stream().count()>=2){
                System.out.println(i.getValue());
            }
        }


    }
}


class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}