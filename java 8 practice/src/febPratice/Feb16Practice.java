package febPratice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Feb16Practice {
    public  static void main(String[] args){

        //find duplicate charaters
        String str ="sudarshann";
       Map<String ,Long> res= Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       res.entrySet().stream().filter(e->e.getValue()>1).forEach(System.out::println);

       // find the highes sal in eaach dept

        List<Employee4> employees = Arrays.asList(
                new Employee4(1, "Alice", "HR", 50000),
                new Employee4(2, "Bob", "IT", 80000),
                new Employee4(3, "Charlie", "HR", 70000),
                new Employee4(4, "David", "IT", 90000),
                new Employee4(5, "Eve", "Finance", 60000)
        );

       Map<String,Optional<Employee4>> resmap = employees.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.maxBy(Comparator.comparing(Employee4::getSalary))));
                resmap.entrySet().stream().forEach(e->System.out.println(e.getKey()+e.getValue().get().getSalary()));

                resmap.entrySet().stream().map(e->e.getValue().get().getName()).forEach(e->System.out.println(" the name of the emp with hish sal is "+e));

                // print even odd numbers


        List<Integer> list = Arrays.asList(3, 5, 6, 8,2,1,6,10);

       Map<Boolean,List<Integer>> reslist = list.stream().collect(Collectors.partitioningBy(e->e%2==0));

       reslist.entrySet().stream().filter(Map.Entry::getKey).forEach(e->System.out.println(" even List is :"+e));

       reslist.entrySet().stream().filter(e-> !e.getKey()).forEach(e->System.out.println(" odd list is"+e));




    }

}
