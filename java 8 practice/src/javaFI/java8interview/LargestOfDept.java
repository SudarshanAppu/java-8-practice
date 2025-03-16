package javaFI.java8interview;
import java.util.*;
import java.util.stream.Collectors;


public class LargestOfDept {

    public static void main(String [] args){

        List<Employee3> employees = Arrays.asList(
                new Employee3(1, "Alice", "HR", 50000),
                new Employee3(2, "Bob", "IT", 80000),
                new Employee3(3, "Charlie", "HR", 70000),
                new Employee3(4, "David", "IT", 90000),
                new Employee3(5, "Eve", "Finance", 60000)
        );


        Map<String, Optional<Employee3>> map = employees.stream().collect(Collectors.groupingBy(Employee3::getDept, Collectors.maxBy(Comparator.comparing(Employee3::getSalary))));

    }
}
