package febPratice;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Feb02Pratice {
    public static void main(String [] args) {

        //remove duplicates from the list
        List<Integer> duplist;
        duplist = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9);
        Set<Integer> set = new HashSet<>();
       var dups =  duplist.stream().filter(e->!set.add(e)).toList();
       System.out.println(dups);

       //frequency of each charater

//        duplist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet().forEach(System.out::println);

        //frequency of each charater which greateer than 1
        duplist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>1)
                .forEach(System.out::println);
//        System.out.println(" list is :" + duplist);
//
//        List<Integer> res = duplist.stream().distinct().toList();
//
//        System.out.println("new list without duplicates is :" + res);
//
//
//        //frequeny of each element in an array
//
//        Map<Integer, Long> resmap = duplist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        System.out.println(" frequency of each character in list: ");
//
//        resmap.entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);
//
//
        //find the duplicate
        String str = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";

        Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>1)
                .forEach(System.out::println);
//
//        List<String> strList = List.of(str.split(" "));
//
//
//        Map<String,Long> dupmap = strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        dupmap.entrySet().stream().filter(e->e.getValue()>1).forEach(System.out::println);
//
        List<Employee4> employees = Arrays.asList(
                new Employee4(1, "Alice", "HR", 50000),
                new Employee4(2, "Bob", "IT", 80000),
                new Employee4(3, "Charlie", "HR", 70000),
                new Employee4(4, "David", "IT", 90000),
                new Employee4(5, "Eve", "Finance", 60000)
        );

           employees.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.maxBy(
                Comparator.comparing(Employee4::getSalary))))
                   .entrySet().forEach(e->System.out.println(e.getKey()+ ":"+e.getValue().get().getSalary()));


               employees.stream().collect(Collectors.groupingBy(Employee4::getDept,Collectors.maxBy(Comparator.comparing(
                       Employee4::getSalary
               )))).entrySet().forEach(e->System.out.println(e.getKey()+":"+e.getValue().get().getSalary()));
//       Map<String, Optional<Employee4>> highSal =  employees.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.maxBy(
//                Comparator.comparing(Employee4::getSalary))));
//
//       highSal.entrySet().stream().forEach(e->System.out.println(e.getKey()+e.getValue().get().getSalary()));
//
//
//       //joining of 3 string prefix sufix and delimeter
//
//        List<String>  stringsconcat = new ArrayList<>();
//        String str1= "name";
//        String str2 = "age";
//        String str3 = "address";
//
//
//      String concat =   stringsconcat.stream().collect(Collectors.joining("age",str2,str3));
//      System.out.println(concat);


        // reverse each string and print the strings

        String[] s = {"name", "age", "address"};

        var resString = Arrays.stream(s).map(e->new StringBuffer(e).reverse()).collect(Collectors.toList());

        System.out.println(resString);
//        System.out.println(Arrays.stream(s).toList());
//       var ss= Arrays.stream(s).map(e-> new StringBuffer(e).reverse()).collect(Collectors.toList());
//        System.out.println(ss);

       String str2 = "name age address";

var revStr=       Arrays.stream(str2.split(" ")).map(e->new StringBuffer(e).reverse())
               .collect(Collectors.joining(",","[","]"));

System.out.println(revStr);

//       var  revres =Arrays.stream(str2.split(" ")).map(e->new StringBuffer(e).reverse())
//               .collect(Collectors.joining(",","[","]"));
//       System.out.println(revres);
//                       .forEach(System.out::print);

    }
}



