package javaFI.corejava;

import java.util.*;
import java.util.stream.Collectors;

class Employee2 {
    private int id;
    private String name;
    private String dept;
    private long salary;

    // Constructor, Getters and Setters
    public Employee2(int id, String name, String dept, long salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public long getSalary() {
        return salary;
    }
}

public class JavaStrampratice {
        public static void main(String[] args) {
            List<Employee2> employees = Arrays.asList(
                    new Employee2(1, "Alice", "HR", 50000),
                    new Employee2(2, "Bob", "IT", 80000),
                    new Employee2(3, "Charlie", "HR", 70000),
                    new Employee2(4, "David", "IT", 90000),
                    new Employee2(5, "Eve", "Finance", 60000)
            );























           Map<String, Optional<Employee2>> map1 =employees.stream().collect(Collectors.groupingBy(Employee2::getDept, Collectors.maxBy(Comparator.comparing(Employee2::getSalary))));

           map1.forEach((dept,emp)-> emp.ifPresent(emp1->System.out.println(emp1.getDept()+" : "+emp1.getSalary())) );

            String[]  strings = new String[5];


          Map<String,Optional<Employee2>> map3 =  employees.stream().collect(Collectors.groupingBy(Employee2::getDept, Collectors.maxBy(Comparator.comparing(Employee2::getSalary))));

            map3.forEach((dept,emp)->
                    emp.ifPresent(e->System.out.println("map3"+e.getDept()+":"+e.getSalary())));

            System.out.println("sorting of emp in desc");
     employees.stream().sorted((e1,e2)-> (int) (e2.getSalary()-e1.getSalary())).forEach(e->System.out.println(e.getName()+":"+e.getSalary()));

            System.out.println("end of sorting");
            System.out.println("");
            System.out.println("");

            System.out.println("sorting of emp in desc");

            employees.stream().sorted((e1,e2)->e2.getName().compareTo(e1.getName())).forEach(e->System.out.println(e.getName()+":"+e.getSalary()));
            System.out.println("end of sorting");
            System.out.println("");
            System.out.println("");

            String str = employees.stream().filter(s -> s.getName().startsWith("C")).toList().get(0)

                            .getName();

            System.out.println("String : "+new String(str));
            char[] chars = str.toCharArray();
            char[] res = new char[str.length()];
            int j=0;
            for(int i=str.length()-1; i>=0;i--){
                res[j]= chars[i];
                j++;
            }

            System.out.println("Reverse of a string is :  "+ new String(res));
            char[] res1 = new char[str.length()];

            for(int i =0;i<str.length();i++){
                res1[i] = chars[str.length()-i-1];
            }
            System.out.println( " reverse string another way : "+ new String(res));







//            Map<String, Optional<Employee2>> map = employees.stream().collect(Collectors.groupingBy(Employee2::getDept,
//                    Collectors.maxBy(Comparator.comparing(Employee2::getSalary))));
//
//            map.forEach((dept , emp)->
//                    emp.ifPresent(employee2 -> System.out.println(employee2.getDept()+" "+employee2.getSalary())));
//        }







            Map<Object, Optional<Employee2>> map = employees.stream().collect(Collectors.groupingBy(Employee2::getDept,Collectors.maxBy(Comparator.comparing(Employee2::getSalary))));


            map.forEach((dept, emp)->emp.ifPresent(emp1->System.out.println(emp1.getDept()+" : "+emp1.getSalary())));





        }

}
