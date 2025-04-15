package marchpratice;

import febPratice.Department;
import febPratice.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class March21 {
public static void main(String[] args) {
    System.out.println("Try programiz.pro");
    int[] arra1 = {1, 2, 3, 4, 5};
    Arrays.stream(arra1).filter(e->e%2==0)
            .map(e->e*e)
            .forEach(e->System.out.print(e+","));

/*    Original Stream: [1, 2, 3, 4, 5]
            |
            +-------------------+
            |   filter(n -> n%2==0)  |
            +-------------------+
            |
    Filtered Stream: [2, 4]
            |
            +-------------------+
            |    map(n -> n*2)     |
            +-------------------+
            |
    Transformed Stream: [4, 8]
            |
            +-----------------------------+
            |   collect(Collectors.toList()) |
            +-----------------------------+
            |
    Final Result: [4, 8]*/

    List<Student> studentList = new ArrayList<>();
    List<Department> departmentList = new ArrayList<>();
    // Departments
    Department cs = new Department(1, "Computer Science");
    Department ee = new Department(2, "Electrical Engineering");
    Department mech = new Department(3, "Mechanical Engineering");

    departmentList.add(cs);
    departmentList.add(ee);
    departmentList.add(mech);

    // Students
    studentList.add(new Student(101, "Alice", Arrays.asList(1))); // Alice is in CS
    studentList.add(new Student(102, "Bob", Arrays.asList(1, 2))); // Bob is in CS and EE
    studentList.add(new Student(103, "Charlie", Arrays.asList(2))); // Charlie is in EE
    studentList.add(new Student(104, "David", Arrays.asList(3))); // David is in ME
    studentList.add(new Student(105, "Eve", Arrays.asList(2))); // Eve is in EE

    // prvoivde department name atleast two students enrolld to it

    Map<Integer,Long> dupdepts= studentList.stream().flatMap(e->e.getDeptIds().stream())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    departmentList.stream().filter(e->dupdepts.getOrDefault(e.getDepartmentId(),0L)>=2)
            .map(Department::getDeptName)
            .forEach(System.out::println);

    System.out.println("YES".equals(null));

    String str=null;
    System.out.println("yes".equals(str));

    String inputString = "Java Concept Of The Day".replaceAll("\\s+", "");

    //find first non repeating character
    var output=Arrays.stream(inputString.split(""))
            .collect(Collectors.groupingBy(Function.identity(), TreeMap::new ,Collectors.counting()))
            .entrySet().stream().filter(e->e.getValue()==1)
            .findFirst().get();
    System.out.println(output);

    //problem statment find the day when stock is minimum to buy stock & find the day when stack is max to sell
    // out put : day 2 & day 7
    List<Integer> list = Arrays.asList(3, 1, 6, 8,2,6,10);
    System.out.println(list.indexOf(10));
    Optional<Integer> min= list.stream().reduce((a, b)->a<b?list.indexOf(a): list.indexOf(b));
    Optional<Integer> max =list.stream().reduce((a, b)->a>b?list.indexOf(a):list.indexOf(b));
    System.out.println("day "+(min.get()+1)+" & day "+(max.get()+1));
}

}
