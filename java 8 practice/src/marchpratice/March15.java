package marchpratice;

import febPratice.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class March15 {

    public static void main(String[] args){
        String strBumrah = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";

        // find the logest string and and minimum string
        String logeststr = Arrays.stream(strBumrah.split(" "))
                .max(Comparator.comparing(String::length))
                .get();

        System.out.println("longest string is :"+logeststr);

        String minStr = Arrays.stream(strBumrah.split(" "))
                .min(Comparator.comparing(String::length))
                .get();

        System.out.println("String minimum legth"+minStr);

        //joining same alpabet with underscore
        Arrays.stream(strBumrah.split(" "))
                .collect(Collectors.groupingBy(e->e.charAt(0), Collectors.joining("_")))
                .entrySet().forEach(System.out::println);


        //find the duplicate
        System.out.println("duplicates");
         Arrays.stream(strBumrah.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>=2)
                .forEach(System.out::println);

        //reverser of each string

        Arrays.stream(strBumrah.split(" "))
                .map(e->new StringBuilder(e).reverse())
                .forEach(e-> System.out.print(e+" "));




        // revers of a string using for loop
        System.out.println("\n==================== reverse of strign -=====================");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<strBumrah.length();i++){
            stringBuilder.append(strBumrah.charAt(strBumrah.length()-i-1));
        }

        System.out.println(" revers of a strigng 1"+stringBuilder);


        // reverse of String using for loop and char array(without using string builder)str = "Sudarshan"
        String revstr = "Sudarshan";

        StringBuilder stringBuilder1 = new StringBuilder();
        for(int i =0;i<revstr.length();i++){
            stringBuilder1.append(revstr.charAt(revstr.length()-i-1));
        }
        System.out.println(stringBuilder1);
        stringBuilder1.append('_');

        for(int i =revstr.length()-1;i>=0;i--){
            stringBuilder1.append(revstr.charAt(i));
        }
        System.out.println(stringBuilder1);

        char[] charArry = revstr.toCharArray();
        char[] resArry  = new char[revstr.length()];
        for(int i = 0;i<charArry.length;i++){
            resArry[i]= charArry[charArry.length-i-1];
        }
        System.out.println();
        Arrays.stream(Arrays.toString(resArry).split(""))
                .forEach(e-> System.out.print(e));
        System.out.println("\n"+String.valueOf(resArry));
//
//        System.out.println();
//        for(char i : resArry){
//            System.out.print(resArry[i]);
//        }


        List<Integer> list = Arrays.asList(3, 5, 6, 8,2,1,6,10);


        // print even odd numbers

        list.stream().collect(Collectors.partitioningBy(e->e%2==0))
                .entrySet().stream()
                .filter(Map.Entry::getKey).forEach(System.out::println);


        List<Employee> employeeList = Database.database();

        //           //when you need just count of and employee
        long count =employeeList.stream().count();
        System.out.println("count is"+count);

        //average of salary of male

employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
        .entrySet().stream()
        .forEach(System.out::println);

double avrsalary = employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println(avrsalary);



        //        //name of all the departmenst
        System.out.println();

        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);


        //        //names of all emloyees who joined after 2015
        System.out.println();


        //        //sort employees based names and  joining year after 2015
        System.out.println();

        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .map(Employee::getName)
                        .forEach(System.out::print);


        //        //youngest male candidate in product Development
        System.out.println();

// employeeList.stream()
//                .collect(Collectors.groupingBy(e->e.getGender().equalsIgnoreCase("male"),
//                        Collectors.minBy(Comparator.comparing(Employee::getAge))))
//                        .entrySet().stream()
//                        .forEach(e-> System.out.println(e.getValue().get()));

        //minimum salary in males

        String name =employeeList.stream().filter(e->e.getGender().equalsIgnoreCase("male"))
                .min(Comparator.comparing(Employee::getSalary))
                        .map(Employee::getName).get();

        System.out.println(name);






//                        .forEach(e-> System.out.println(e.getKey()+":"+e.getValue().get()));

        //        //third largest salary
        System.out.println();




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



        // atlest 2 students to enroll




// no students or only 1 student to enroll in depatment


        // find the highest sal in eaach dept

        List<Employee4> employees = Arrays.asList(
                new Employee4(1, "Alice", "HR", 50000),
                new Employee4(2, "Bob", "IT", 80000),
                new Employee4(3, "Charlie", "HR", 70000),
                new Employee4(4, "David", "IT", 90000),
                new Employee4(5, "Eve", "Finance", 60000)
        );
        System.out.println();

        int[] arr  = {2, 6, 1, 6, 7};

        //reverse of an array


//        IntStream.rangeClosed(1,arr.length).map(e->arr[arr.length-e]).forEach(System.out::print);
//        String str = "sudarshan";
//
//        System.out.println("\nrev of String "+str);


        //find the duplicate
        String strBumrah1 = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";





        // reverse each string and print the strings

        String[] s = {"name", "age", "address"};

        //remove duplicates from the list

        Map<String, String> map = new HashMap<>();

        map.put("California", "USA");
        map.put("Florida", "USA");
        map.put("Texas", "USA");
        map.put("Nevada", "USA");
        map.put("Baja California", "Mexico");
        map.put("Oaxaca", "Mexico");
        map.put("Sinaloa", "Mexico");
        map.put("Alberta", "Canada");
        map.put("British Columbia", "Canada");
        map.put("UP", "India");
        map.put("MP", "India");
        map.put("Bihar", "India");
        map.put("Rajasthan", "India");
        map.put("Assam", "India");
//  o/p : India : 5

        System.out.println("natiion and stats no");

        List<String> lst = Arrays.asList("prsh10","sud2","pru5","lok1");




    }





}
