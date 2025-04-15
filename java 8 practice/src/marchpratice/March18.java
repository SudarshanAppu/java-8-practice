package marchpratice;

import febPratice.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class March18 {
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


        List<Integer> list = Arrays.asList(3, 2, 6, 8,2,6,10);
//       int min= list.stream().reduce(0,(a,b)->a<b?list.get(a): list.get(b));
//       int max =list.stream().reduce(0,(a,b)->a>b?list.get(a):list.get(b));
//        System.out.println("day"+min+" & day"+max);

//       FindMinandMax();
        System.out.println("=======================================================================");
        List<Employee> employeeList = Database.database();
        //           //when you need just count of and employee
        long count = employeeList.stream().count();

        System.out.println(count);
        //        //name of all the departmenst
        employeeList.stream().map(Employee::getDepartment)
                .forEach(System.out::println);

        //        //names of all emloyees who joined after 2015

        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .map(Employee::getName)
                        .forEach(System.out::println);
        //        //sort employees based names and  joining year after 2015
        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                        .forEach(System.out::println);


        //        //youngest male candidate in product Development

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getAge))))
                .entrySet().stream().forEach(e-> System.out.println(e.getKey()+": "+ e.getValue().get().getAge()));
        //        //third largest salary

        double salary1 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(2).findFirst().get().getSalary();
        System.out.println("3rd highest sal is "+salary1);

        System.out.println("=======================================================================");

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

        Map<Integer, Long> collectDeptids = studentList.stream().flatMap(e -> e.getDeptIds().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        departmentList.stream().filter(e->collectDeptids.getOrDefault(e.getDepartmentId(),0L)>=2)
                .map(e->e.getDeptName())
                .forEach(e-> System.out.println(e));


        // find the highest sal in eaach dept


        List<Employee4> employees = Arrays.asList(
                new Employee4(1, "Alice", "HR", 50000),
                new Employee4(2, "Bob", "IT", 80000),
                new Employee4(3, "Charlie", "HR", 70000),
                new Employee4(4, "David", "IT", 90000),
                new Employee4(5, "Eve", "Finance", 60000)
        );

        // find the highest sal in eaach dept

        employees.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.maxBy(Comparator.comparing(Employee4::getSalary))))
                .entrySet().stream().forEach(e-> System.out.println(e.getKey()+" : "+e.getValue().get().getSalary()));

        // min sal

          employees.stream().collect(Collectors.groupingBy(Employee4::getDept, Collectors.minBy(Comparator.comparing(Employee4::getSalary))))
                  .entrySet().stream().forEach(e-> System.out.println(e.getKey()+":"+e.getValue().get().getSalary()));

          //avr sal of each dept

        double avg =employees.stream().mapToDouble(e->e.getSalary()).average().getAsDouble();

        System.out.println("avg sal: " +avg);

        //min sal overall
        long salary = employees.stream().min(Comparator.comparing(Employee4::getSalary)).get().getSalary();

        System.out.println("min sal"+salary);
        //reverse of a array
        int[] arr  = {2, 6, 1, 6, 7};


        String str = "sudarshan";

        System.out.println("\nrev of String "+str);

        int[] revint =str.chars().toArray();

        IntStream.rangeClosed(1,revint.length)
                .map(e->revint[revint.length-e])
                .mapToObj(e->(char)e)
                .forEach(System.out::print);

        System.out.println();
        //find the duplicate
        String strBumrah = "I am really nervous about Bumrah fitness status. \n" +
                "India might finish up with 175 or maybe 200 and without\n" +
                " Bumrah that would be almost impossible to defend. Bumrah is best bowler in the world";



Arrays.stream(strBumrah.split(" "))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue()>=2)
        .forEach(System.out::println);

        // reverse each string and print the strings

        String[] s = {"name", "age", "address"};

        Arrays.stream(s).map(e->new StringBuilder(e).reverse())
                .forEach(e-> System.out.print(e+","));
        System.out.println();
        //remove duplicates from the list
        List<Integer> duplist;
        duplist = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9);

        duplist.stream().distinct().forEach(e-> System.out.print(e+","));

        //duplicate using set
        System.out.println();
        Set<Integer> set = new HashSet<>();
        duplist.stream().filter(e->!set.add(e)).forEach(e-> System.out.print(e+","));
        //remove duplicates using
        System.out.println();
        Set<Integer> set1 = new HashSet<>();
        duplist.stream().filter(set1::add).forEach(e-> System.out.print(e+","));

        //find duplicates along with count
        System.out.println();
        duplist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream().filter(e->e.getValue()>=2)
                .forEach(e-> System.out.print(e+","));

        System.out.println();

        //find the 3rd largest element in array

        int i = duplist.stream().sorted(Comparator.reverseOrder()).distinct()
                .skip(2).findFirst().get();

        System.out.println("3rd largest is :"+i);

        //without using comparator reverse order  find 3rd largest

        Object[] dupArray = duplist.toArray();
        OptionalInt first = IntStream.rangeClosed(1, dupArray.length).distinct()
                .map(e -> (int) dupArray[dupArray.length - e])

                .limit(3).skip(2).findFirst();

        System.out.println(" the third largest is :"+first.getAsInt());
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

        map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.counting()))
                .entrySet().forEach(System.out::println);

        //sort based on digits
        List<String> lst = Arrays.asList("prsh10","sud2","pru5","lok1");

        lst.stream().sorted(Comparator.comparing(March18::extract))
                .forEach(e-> System.out.print(e+" "));

    }


    public static int extract(String str){
        String resString  = str.replaceAll("\\D","");
        return resString.isEmpty()?0:Integer.parseInt(resString);
    }
}
