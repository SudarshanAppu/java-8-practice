package marchpratice;

import febPratice.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class March13 {
    public static void main(String[] args){
        String strBumrah = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";

        // find the logest string and

        String logestString =Arrays.stream(strBumrah.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println("longest string an string array is :"+logestString);
        String minString = Arrays.stream(strBumrah.split(" "))
                .min(Comparator.comparing(String::length))
                .get();
        System.out.println("smallest length string is :"+minString);

        //find the duplicate
        Arrays.stream(strBumrah.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>=2)
                .forEach(System.out::println);
        //reverser of each string

        Arrays.stream(strBumrah.split(" "))
                .map(e->new StringBuilder(e).reverse())
                .forEach(e-> System.out.print(e+" "));

        //reverse of whole sentace then reverse the words


//        Arrays.stream(strBumrah.split(""))
//                .sorted(Comparator.reverseOrder())
//                .forEach(e->System.out.print(e+" "));
        // reverse of String str = "Sudarshan"
        String revstr = "Sudarshan";
        // revers of a string using for loop
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<revstr.length();i++){
            stringBuilder.append(revstr.charAt(revstr.length()-i-1));
        }
        System.out.println(" \nrev string is :"+stringBuilder);

        stringBuilder.append('_');
        for(int i = revstr.length()-1;i>=0;i--){
            stringBuilder.append(revstr.charAt(i));
        }
        System.out.println(" \nrev string is 2:"+stringBuilder+"\n");

        char[] chArray = revstr.toCharArray();
        char[] resArr =  new char[revstr.length()];
        for(int i = 0;i<chArray.length;i++){
            resArr[i] = chArray[chArray.length-i-1];

        }
        for(char ch : resArr){
            System.out.print(ch);
        }
        System.out.println("\n"+new String(resArr));
        System.out.println(String.valueOf(resArr));

        Arrays.stream(Arrays.toString(resArr).split(""))
                .forEach(System.out::print);

        char[] resArr2 = new char[revstr.length()];
        for(int i =chArray.length-1,j=0;i>=0;i--,j++){
            resArr2[j]=chArray[i];
        }
        System.out.println();

        for(char ch:resArr2){
            System.out.print(ch);
        }

        System.out.println(new String(resArr2));
        System.out.println(String.valueOf(resArr2));

        Arrays.stream(Arrays.toString(resArr2).split(""))
                .forEach(System.out::print);

        // print even odd numbers
        List<Integer> list = Arrays.asList(3, 5, 6, 8,2,1,6,10);

        System.out.println();
        list.stream().collect(Collectors.groupingBy(e->e%2==0))
                .entrySet().stream()
                .forEach(System.out::println);

        List<Employee> employeeList = Database.database();
        //           //when you need just count of and employee

        long count = employeeList.stream().count();
        System.out.println("count is "+count);
        //        //name of all the departmenst
        System.out.println();

        employeeList.stream().map(e->e.getDepartment()).distinct()
                .forEach(System.out::println);
        //        //names of all emloyees who joined after 2015
        System.out.println();

        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .map(e->e.getName())
                .forEach(System.out::println);
        //        //sort employees based names and  joining year after 2015
        System.out.println();

        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .forEach(System.out::println);
        //        //youngest male candidate in product Development
        System.out.println();

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getAge))))
                .entrySet().stream()
                        .map(e->e.getValue().get())
                                .collect(Collectors.toMap(Employee::getDepartment, Employee::getName))
                                        .entrySet().stream()
                        .forEach(System.out::println);


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

      Map<Integer,Long> deptreslist = studentList.stream().flatMap(e->e.getDeptIds().stream())
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      System.out.println(deptreslist);

      departmentList.stream().filter(e->deptreslist.getOrDefault(e.getDepartmentId(),0L)>=2)
              .map(Department::getDeptName)
              .forEach(System.out::println);

// no students or only 1 student to enroll in depatment

       Map<Integer,Long> iddepts = studentList.stream().flatMap(e->e.getDeptIds().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(iddepts);

        departmentList.stream().filter(e->iddepts.getOrDefault(e.getDepartmentId(),0L)<2)
                .map(Department::getDeptName)
                .forEach(System.out::println);

        // find the highest sal in eaach dept

        List<Employee4> employees = Arrays.asList(
                new Employee4(1, "Alice", "HR", 50000),
                new Employee4(2, "Bob", "IT", 80000),
                new Employee4(3, "Charlie", "HR", 70000),
                new Employee4(4, "David", "IT", 90000),
                new Employee4(5, "Eve", "Finance", 60000)
        );
        System.out.println();
        employees.stream().collect(Collectors.groupingBy(e->e.getDept(), Collectors.maxBy(Comparator.comparing(Employee4::getSalary))))
                .entrySet().stream()
                .forEach(e-> System.out.println(e.getKey()+":"+e.getValue().get().getSalary()));

        int[] arr  = {2, 6, 1, 6, 7};

        //reverse of an array

        IntStream.rangeClosed(1,arr.length)
                .map(e->arr[arr.length-e])
                .forEach(e-> System.out.print(e+","));
//        IntStream.rangeClosed(1,arr.length).map(e->arr[arr.length-e]).forEach(System.out::print);
//        String str = "sudarshan";
//
//        System.out.println("\nrev of String "+str);


        //find the duplicate
        String strBumrah1 = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";

        Arrays.stream(strBumrah1.split(" "))
                .collect(Collectors.groupingBy(e->e.charAt(0), Collectors.joining("_")))
                .entrySet().stream()
                .forEach(System.out::println);

//        Arrays.stream(str.split(" "))
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet().stream().filter(e->e.getValue()>1)
//                .forEach(System.out::println);



        // reverse each string and print the strings

        String[] s = {"name", "age", "address"};

        //remove duplicates from the list
//        List<Integer> duplist;
//        duplist = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9);
//        Set<Integer> set = new HashSet<>();
//        var dups =  duplist.stream().filter(e->!set.add(e)).toList();
//        System.out.println(dups);

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
        map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()))
                .entrySet().stream()
                .forEach(System.out::println);

        System.out.println(" sort based on number");
        List<String> lst = Arrays.asList("prsh10","sud2","pru5","lok1");
        lst.stream().sorted(Comparator.comparing(March13::extractNumber))
                .forEach(e-> System.out.print(e+" "));

//        lst.stream().sorted(Comparator.comparing(Example::extractNumber))
//                .forEach(e->System.out.println(" "+e+" "));

    }

    public static int extractNumber(String str){
        String resString = str.replaceAll("\\D+","");

        return resString.isEmpty()?0:Integer.parseInt(resString);
    }


//    public static int extractNum(String str ){
//        String resString = str.replaceAll("\\D+","");
//        System.out.println(resString);
//        return  resString.isEmpty()?0:Integer.parseInt(resString);
//    }
}
