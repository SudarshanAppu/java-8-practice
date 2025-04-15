package marchpratice;

import febPratice.Department;
import febPratice.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class march11 {
    public static void main(String[] args){

        // reverse of String str = "Sudarshan"
        String revstr = "Sudarshan";
        int[] chars =
                revstr.chars().toArray();
//        Stream<Character> characterStream =
                IntStream.rangeClosed(1, chars.length)
                .map(e -> chars[chars.length - e])

                .mapToObj(e -> (char) e)
                .forEach(System.out::print);
        System.out.println();

        char[] charArray = revstr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=charArray.length-1; i>=0 ;i--){
            stringBuilder.append(charArray[i]);
        }
        System.out.println(stringBuilder);
        // print even odd numbers
        List<Integer> list = Arrays.asList(3, 5, 6, 8,2,1,6,10);

                List<Employee> employeeList = Database.database();
        //           //when you need just count of and employee
        //        //name of all the departmenst
        //        //names of all emloyees who joined after 2015
        //        //sort employees based names and  joining year after 2015
        //        //youngest male candidate in product Development
        //        //third largest salary



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


        // find the highest sal in eaach dept

        List<Employee4> employees = Arrays.asList(
                new Employee4(1, "Alice", "HR", 50000),
                new Employee4(2, "Bob", "IT", 80000),
                new Employee4(3, "Charlie", "HR", 70000),
                new Employee4(4, "David", "IT", 90000),
                new Employee4(5, "Eve", "Finance", 60000)
        );


        int[] arr  = {2, 6, 1, 6, 7};

        IntStream.rangeClosed(1,arr.length).map(e->arr[arr.length-e]).forEach(System.out::print);
        String str = "sudarshan";

        System.out.println("\nrev of String "+str);


        //find the duplicate
        String strBumrah = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";

        Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>1)
                .forEach(System.out::println);



        // reverse each string and print the strings

        String[] s = {"name", "age", "address"};

        //remove duplicates from the list
        List<Integer> duplist;
        duplist = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9);
        Set<Integer> set = new HashSet<>();
        var dups =  duplist.stream().filter(e->!set.add(e)).toList();
        System.out.println(dups);

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


        List<String> lst = Arrays.asList("prsh10","sud2","pru5","lok1");
        lst.stream().sorted(Comparator.comparing(Example::extractNumber))
                .forEach(e->System.out.println(" "+e+" "));

    }
    public static int extractNum(String str ){
        String resString = str.replaceAll("\\D+","");
        System.out.println("String value is "+resString);
        return  resString.isEmpty()?0:Integer.parseInt(resString);
    }
}
