package marchpratice;

import febPratice.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class march11practice {
    public static void main(String[] args){

        // reverse of String str = "Sudarshan"
        String revstr = "Sudarshan";

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<revstr.length();i++){
            stringBuilder.append(revstr.charAt(revstr.length()-i-1));
        }
        System.out.println("reverse of a string :"+stringBuilder);

        // print even odd numbers
        List<Integer> list = Arrays.asList(3, 5, 6, 8,2,1,6,10);

        var evenOdd = list.stream().collect(Collectors.groupingBy(e->e%2==0));
        evenOdd.entrySet().stream().filter(Map.Entry::getKey)
                .forEach(System.out::println);
        evenOdd.entrySet().stream().filter(e->!e.getKey())
                .forEach(System.out::println);
        System.out.println("\n\n");

                List<Employee> employeeList = Database.database();
        //           //when you need just count of and employee
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .values().stream().map(employee -> employee.get().getName())
                .forEach(e-> System.out.println(" "+e));
//                .entrySet().stream().forEach(System.out::println);
        System.out.println("\n\n");

        //        //name of all the departmenst

                employeeList.stream().map(Employee::getDepartment).distinct().forEach(e-> System.out.println(e));
        //        //names of all emloyees who joined after 2015
        System.out.println("\n\n");

        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .map(Employee::getName).forEach(System.out::println);
        System.out.println("\n\n");

        //        //sort employees based names and  joining year after 2015
        employeeList.stream().filter(e->e.getYearOfJoining()>2015).
                sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                        .forEach(System.out::println);

        System.out.println("\n\n");


        //        //youngest male candidate in product Development

        String name = employeeList.stream().filter(e->e.getGender().equalsIgnoreCase("male")&&
                e.getDepartment().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparing(Employee::getAge)).get().getName();
//                        .get().getName();
        System.out.println("young emp in product dept"+name+" \n\n");

        //        //third largest salary

        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .limit(3).skip(2).forEach(System.out::println);
        System.out.println("\n\n");




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

        var deptids = studentList.stream().flatMap(e->e.getDeptIds().stream()).collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        ));

        departmentList.stream().filter(e->deptids.getOrDefault(e.getDepartmentId(),0L)>=2)
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

        var highSal = employees.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.maxBy(Comparator.comparing(Employee4::getSalary))));

         highSal.entrySet().forEach(e->System.out.println(e.getKey()+":"+e.getValue().get().getSalary()));

        int[] arr  = {2, 6, 1, 6, 7};
        IntStream.rangeClosed(1,arr.length)
                .map(e->arr[arr.length-e])
                .forEach(e->System.out.print(e));

//        IntStream.rangeClosed(1,arr.length).map(e->arr[arr.length-e]).forEach(System.out::print);
        String str = "sudarshan";
        StringBuilder stringBuilder1 = new StringBuilder();
        for(int i = 0; i<str.length();i++){
            stringBuilder1.append(str.charAt(str.length()-i-1));
        }

        stringBuilder1.append('_');
        System.out.println("\nrev of String "+stringBuilder1);
        for(int i =str.length()-1;i>=0;i--){
            stringBuilder1.append(str.charAt(i));
        }
        System.out.println("\nrev of String "+stringBuilder1);
        char[] charArr = str.toCharArray();
        char[] resArr = new char[str.length()];

        for(int i =0;i<charArr.length;i++){
            resArr[i]= charArr[charArr.length-i-1];
        }
        for(char i :resArr){
            System.out.print(i);
        }
        System.out.println("\n");
        System.out.print(String.valueOf(resArr));
        System.out.println("\n\n");




        //find the duplicate strings
        String strBumrah = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";

        Arrays.stream(strBumrah.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(e->e.getValue()>=2)
                                .forEach(System.out::println);


//        Arrays.stream(str.split(" "))
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet().stream().filter(e->e.getValue()>1)
//                .forEach(System.out::println);

        System.out.println("\n\n");


        // reverse each string and print the strings

        String[] s = {"name", "age", "address"};
        Arrays.stream(s)
                        .map(e->new StringBuilder(e).reverse())
                                .forEach(e->System.out.print(" "+e));
        System.out.println("\n\n");

        //remove duplicates from the list
        List<Integer> duplist;
        duplist = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9);

        Set<Integer> set = new HashSet<>();
        duplist.stream().filter(e->!set.add(e)).
                forEach(System.out::print);
//        Set<Integer> set = new HashSet<>();
//        var dups =  duplist.stream().filter(e->!set.add(e)).toList();
//        System.out.println(dups);
        System.out.println("\n\n");

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
        System.out.println("\n\n");

        List<String> lst = Arrays.asList("prsh10","sud2","pru5","lok1");
        lst.stream().sorted(Comparator.comparing(march11practice::extractNum))
                .forEach(e->System.out.println(" "+e+" "));


        //find common between the array
        int[] arr1= {1,2,3,4,5,6};
        int[] arr2 = {9,2,4,6,7};

        Arrays.stream(arr1).filter(arr1Num-> Arrays.stream(arr2).anyMatch(arr2Num->arr2Num==arr1Num)).boxed()
                .forEach(System.out::print);
        System.out.println();
        List<Integer> resarr = Arrays.stream(arr1).filter(arr1num->Arrays.stream(arr2).anyMatch(arr2num ->arr2num==arr1num)).boxed()
                .collect(Collectors.toList());
        System.out.println("duplicates are :"+resarr);
    }

    public static int extractNum(String str ){
        System.out.println("String is :"+str);

        String resString = str.replaceAll("\\D+","");
        System.out.println("restString is :"+resString);
        return  resString.isEmpty()?0:Integer.parseInt(resString);
    }
}
