package febPratice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class March05 {
    public static void main(String [] args
    ){

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


        var name =studentList.stream().map(e->e.getName())
                .max(Comparator.comparing(String::length))
                .get();
        System.out.println(name);

        // atlest 2 students to enroll

        var deptids2stunts =studentList.stream().flatMap(e->e.getDeptIds().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



        departmentList.stream().filter(e->deptids2stunts.getOrDefault(e.getDepartmentId(),0L)>=2)
                .map(e->e.getDeptName())
                .forEach(System.out::println);


//        var studentres= studentList.stream().flatMap(e->e.getDeptIds().stream())
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//
//        departmentList.stream().filter(e->studentres.getOrDefault(e.getDepartmentId(),0L)>=2)
//                .map(Department::getDeptName).forEach(System.out::println);
//
//
//        var deptidlist =studentList.stream().flatMap(e->e.getDeptIds().stream()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));//1 1 2 2 3 2
//
//        departmentList.stream().filter(e->deptidlist.getOrDefault(e.getDepartmentId(),0L)>=2)
//                .map(Department::getDeptName).forEach(System.out::println);
//
//


//
//        var stdls = studentList.stream().flatMap(e->e.getDeptIds().stream())
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//
//        //var result =
//                departmentList.stream().filter(e->stdls.getOrDefault(e.getDepartmentId(),0L)>=2)
//                        .map(e->e.getDeptName())
//                .forEach(System.out::println);
//                .map(Department::getDeptName).collect(Collectors.toList());


//        System.out.println(result);

//        String str = "Sudarshan";
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0;i<str.length();i++){
//            stringBuilder.append(str.charAt(str.length()-i-1));
//        }
//
//        StringBuilder stringBuilder1 = new StringBuilder();
//        System.out.println(stringBuilder);
//        for(int i = str.length()-1;i>=0;i--){
//            stringBuilder1.append(str.charAt(i));
//        }
//
//        System.out.println(stringBuilder1);
//
//        String str2 = "abcdbcacbacababc";
//        Map<String,Integer> map = new HashMap<>();
//        for(int i = 0;i<=str2.length()-3;i++){
//            String subString = str2.substring(i,i+3);
//            if(subString.matches("[abc]+") && (repeat(subString))){
//
//                map.put(subString,map.getOrDefault(subString,0)+1);
//            }
//
//        }
//        map.keySet().stream().forEach(System.out::println);
//        map.entrySet().stream().forEach(System.out::println);
//        map.entrySet().stream().filter(e->e.getValue()>1).forEach(e->System.out.println(" subString atleast 2 times: "+e));
//

//
//        //compare and add same elements from arrays
//
//        var arrList= Arrays.stream(arr).collect(Collectors.toList());
//
//        var result = Arrays.stream(arr2).filter(e->arrList.contains(e)).distinct().collect(Collectors.toList());
//
//        result.stream().forEach(e->System.out.print(" "+e));
//
//        System.out.println("\n\n" );
//        //reverse of arr2
//        IntStream.rangeClosed(1,arr2.length).map(e->arr2[arr2.length-e])
//                .forEach(e->System.out.print(" "+e));
//    }
//    public static boolean repeat(String subString){
//        return subString.charAt(0)!=subString.charAt(1) && subString.charAt(0)!=subString.charAt(2)
//                && subString.charAt(1)!=subString.charAt(2);


        // find department name atleast two students enrolled on it
        //reverse of a string //        String str = "Sudarshan";
        // find abc combination in         String str2 = "abcdbcacbacababc";
        Integer[] arr3 = {1, 20, 3, 40, 2, 3};
        Integer[] arr4 = {1, 2, 5, 1, 4, 10, 3};

        //compare and add same elements from arrays



        var studentDeptIds = studentList.stream().flatMap(e->e.getDeptIds().stream())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        departmentList.stream().filter(dept->studentDeptIds.getOrDefault(dept.departmentId,0L)>=2)
                .map(dept->dept.getDeptName())
                .forEach(dname->System.out.print(" "+dname));

        //reverse of a string //        String str = "Sudarshan";

                String str = "Sudarshan";
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0;i<str.length();i++){
                    stringBuilder.append(str.charAt(str.length()-i-1));
                }
                System.out.println("\n 1 reverse of a string :"+stringBuilder);
        stringBuilder.append('_');

                for(int i = str.length()-1;i>=0;i--){
                    stringBuilder.append(str.charAt(i));
                }
        System.out.println("\n 2 reverse of a string :"+stringBuilder+"\n\n");

                //reverse of string without using string builder

        char[] charArr = str.toCharArray();
        char[] revArr = new char[charArr.length];
        for(int i =0;i<charArr.length;i++){
            revArr[i]=charArr[charArr.length-i-1];
        }
        System.out.println(" using traditional foreach");

        for(char ch :revArr){
            System.out.print(ch);
        }

        System.out.println(" \nusing arrays stream");

        Arrays.stream(Arrays.toString(revArr).split(""))
                .forEach(System.out::print);

        System.out.println(" \none more approach");

        char[] orgArr = str.toCharArray();
        char[] arrRev = new char[orgArr.length];

        for(int i =orgArr.length-1, j = 0; i>=0;i--,j++){
            arrRev[j]=orgArr[i];
        }
        System.out.println("2 using traditional foreach");

        for(char ch : arrRev){
            System.out.print(ch);
        }
        System.out.println("\n 2 using arrays stream");

        Arrays.stream(Arrays.toString(arrRev).split(""))
                .forEach(System.out::print);

        System.out.println(" \n reverse of a string using atomicinteger"+"\n strlength"+str.length());
//        AtomicInteger i = new AtomicInteger();
////       i = -1;
//        Arrays.stream(str.split("")).map(e->e.charAt(i.incrementAndGet()))
//                .forEach(System.out::print);
        System.out.println(" end of automicinteger");

        String str2 = "abcdbcacbacababc";

        Map<String,Integer> resMap = new HashMap<>();

        for(int k = 0;k<=str2.length()-3;k++){
            String subString = str2.substring(k,k+3);
            if(subString.matches("[abc]+")                    && (repeat(subString)))
            {
                resMap.put(subString, resMap.getOrDefault(subString,0)+1);
            }
        }

        resMap.entrySet().forEach(e->System.out.println(e));
System.out.println("\n");
//        String str2 = "abcdbcacbacababc";
        Map<String,Integer> map = new HashMap<>();
        for(int k = 0;k<=str2.length()-3;k++){
            String subString = str2.substring(k,k+3);
            if(subString.matches("[abc]+")
                    && (repeat(subString)))
            {

                map.put(subString,map.getOrDefault(subString,0)+1);
            }

        }
        map.entrySet().forEach(System.out::println);


                Integer[] arr = {1, 20, 3, 40, 2, 3};
        Integer[] arr2 = {1, 2, 5, 1, 4, 10, 3};

        Optional<Integer> min = Arrays.stream(arr).reduce((a, b)->a>b?a:b);
        System.out.println("min element is :"+ min.get());

    }
        public static boolean repeat(String subString) {
            return subString.charAt(0) != subString.charAt(1) && subString.charAt(0) != subString.charAt(2)
                    && subString.charAt(1) != subString.charAt(2);
        }

}




