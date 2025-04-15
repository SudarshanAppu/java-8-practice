package marchpratice;

import febPratice.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class April08Pratice {
    public static void main(String[] args) {
        // reverse of String str = "Sudarshan"
        String revstr = "Sudarshan";

        int[] revstrchars = revstr.chars().toArray();
        System.out.println(revstrchars);
        System.out.println(Arrays.toString(revstrchars));

        Object[] array = IntStream.rangeClosed(1, revstrchars.length)
                .map(e -> revstrchars[revstrchars.length - e])
                .mapToObj(e -> (char) e)
                .toArray();

        System.out.println(Arrays.toString(array));

        IntStream.rangeClosed(1,revstrchars.length)
                .map(e->revstrchars[revstrchars.length-e])
                .mapToObj(e->(char)e)
                .forEach(e-> System.out.print(e+","));

        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<revstr.length();i++){
            stringBuilder.append(revstr.charAt(revstr.length()-i-1));
        }
        System.out.println();
        System.out.println(stringBuilder);
        stringBuilder.append("__");
        for(int i =revstr.length()-1;i>=0;i--){
            stringBuilder.append(revstr.charAt(i));
        }
        System.out.println(stringBuilder);


        // print even odd numbers
//        List<Integer> list ;
//             list   = Arrays.asList(3, 5, 6, 8,2,1,6,10);

        int[] arr = {3, 5, 6, 8,2,1,6,10};
//        Arrays.stream(arr).mapToDouble(e->e).collect(Collectors.partitioningBy(e->e%2==0));
        List<Integer> list = Arrays.asList(3, 5, 6, 8,2,1,6,10);

        System.out.println("even numbers");
        list.stream().collect(Collectors.partitioningBy(e->e%2==0))
                .entrySet().stream().filter(Map.Entry::getKey).forEach(System.out::print);

        System.out.println("odd numbers");
        list.stream().collect(Collectors.partitioningBy(e->e%2==0))
                .entrySet().stream().filter(e->!e.getKey())
                .forEach(e-> System.out.print(e));

        List<Employee> employeeList = Database.database();
        System.out.println();
        //           //when you need just count of and employee
        long count = employeeList.stream().count();
        System.out.println(count);
        //        //name of all the departmenst

        employeeList.stream().map(Employee::getDepartment).distinct().forEach(e-> System.out.print(e+","));
        //        //names of all emloyees who joined after 2015

        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .map(e->e.getName()).forEach(System.out::println);
        //        //sort employees based names and  joining year after 2015
        System.out.println("sorting names ");
        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .forEach(System.out::println);
        //        //youngest male candidate in product Development
        System.out.println("youngest employee is :");

        employeeList.stream().filter(e->e.getDepartment().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparing(Employee::getAge))
                .stream().map(Employee::getName).forEach(System.out::println);
        //        //third largest salary
        System.out.println("third highest salary is :");
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary))
                .skip(2).findFirst().stream().map(Employee::getSalary)
                .forEach(System.out::println);

        // find the highest sal in eaach dept
        System.out.println("max salary for each department: ");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))

                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().map(a->a.getSalary()).findFirst().get()))
                .entrySet().stream().forEach(System.out::println);
//    .forEach(System.out::println);

        // find the highest sal in eaach dept
        System.out.println("another max salary for each department: ");

        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue().get().getSalary()))
                .entrySet().stream().forEach(System.out::println);

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


        // atlest 2 students to enrolled depatments names
        System.out.println("output for 2 students enrolled :");

        var studentdepartments =studentList.stream().flatMap(e->e.getDeptIds().stream()).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        departmentList.stream().filter(e->studentdepartments.getOrDefault(e.getDepartmentId(),0L)>=2
                ).map(Department::getDeptName).forEach(System.out::println);


        //problem statment find the day when stock is minimum to buy stock & find the day when stack is max to sell
        // out put : day 2 & day 7
        List<Integer> list1 = Arrays.asList(3, 1, 6, 8,2,6,10);

        Optional<Integer> reduce = list1.stream().reduce((a, b) -> a > b ? list1.indexOf(a) : list1.indexOf(b)).get().describeConstable();

        list1.stream().min((o1,o2)->o1-o2)
                .map(e->list1.indexOf(e))
                .stream().forEach(e-> System.out.println("good day to bu stocks:"+e));

        list1.stream().max(Comparator.comparingInt(o -> o))
                .map(e->list.indexOf(e))
                .stream().forEach(e-> System.out.println("Good day to sell stock:"+e));



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

//        Map<String, List<Map.Entry<String, String>>> collect =
        Map<String, Long> collect = map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()));
//                entrySet().stream().forEach(System.out::println);


        List<String> lst = Arrays.asList("prsh10","sud2","pru5","lok1");
        lst.stream().sorted(Comparator.comparing(April08Pratice::extractNumber))
                .forEach(e->System.out.println(" "+e+" "));
    }

    private static int extractNumber(String s) {
        String res = s.replaceAll("\\D+","");
        return  res.isEmpty()?0:Integer.parseInt(res);
    }
    public static int extractNum(String str ){
        String resString = str.replaceAll("\\D+","");
        System.out.println("String value is "+resString);
        return  resString.isEmpty()?0:Integer.parseInt(resString);
    }

}
