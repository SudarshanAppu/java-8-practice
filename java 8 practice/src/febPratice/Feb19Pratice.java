package febPratice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;




public class Feb19Pratice {

    public static void main(String [] args){

        List<Employee> employeeList = Database.database();

/*        //how many male and female print names of male and female employee
        //           //when you need just count of and employee
        //        //name of all the departmenst
        //        //names of all emloyees who joined after 2015
        //        //sort employees based names and  joining year after 2015
        //        //youngest male candidate in product Development
        //        //third largest salary*/


        //how many male and female print names of male and female employee

        var malefelmale = employeeList.stream().collect(
                Collectors.partitioningBy(e->e.getGender().equalsIgnoreCase("male"))
        );

        malefelmale.entrySet().stream().filter(Map.Entry::getKey)
                .forEach(e->System.out.println("male employee names "+ e.getValue().stream().map(Employee::getName).toList()));

        malefelmale.entrySet().stream().filter(e->!e.getKey())
                .forEach(e->System.out.println(" female employee names"+e.getValue().stream().map(Employee::getName).toList()));


        //        List<Employee> employeeList = Database.database();
        //           //when you need just count of and employee
        //        //name of all the departmenst
        //        //names of all emloyees who joined after 2015
        //        //sort employees based names and  joining year after 2015
        //        //youngest male candidate in product Development
        //        //third largest salary






//      var malefemaleMap=  employeeList.stream().collect(Collectors.partitioningBy(e->e.getGender().equalsIgnoreCase("male")));
//
//           malefemaleMap.entrySet().stream().filter(Map.Entry::getKey).forEach(e->System.out.println("male candidates are :"+e.getValue().stream().map(Employee::getName).collect(Collectors.toList())));
//           malefemaleMap.entrySet().stream().filter(e->!e.getKey()).forEach(e->System.out.println("female candidates are"+e.getValue().stream().map(Employee::getName).collect(Collectors.toList())));
//
//
//           //when you need just count of and employee
//
//           var malefemaleCount =employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//
//           malefemaleCount.entrySet().forEach(e->System.out.println(e));
//
//        //name of all the departmenst
//
//        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
//
//        //average age of male and female employees
//
//               employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)))
//                       .entrySet().forEach(System.out::println);
//
//        //names of all emloyees who joined after 2015
//
//        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
//                .map(e->e.getName())
//                .forEach(System.out::println);
//
//        //sort employees based names and  joining year after 2015
//
//        employeeList.stream().filter(e->e.getYearOfJoining()>2015)
//                .sorted(Comparator.comparing(Employee::getName))
//                .map(e->e.getName())
//                .forEach(e->System.out.print(" "+e));
//
//        //youngest male candidate in product Development
//
//        System.out.println("\n");
//
//        employeeList.stream().filter(e->e.getDepartment().equalsIgnoreCase("product Development"))
//                .min(Comparator.comparing(Employee::getAge)).ifPresent(e->System.out.println("  min age male emp in dept :"+e));
//
//        //third largest salary
//        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
//                        .forEach(e->System.out.println(" "+e.getSalary()));
//
//        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
//                .limit(3).skip(2)
//                .forEach(e->System.out.println(" 3rd highest sal is :"+e));

//        var malefemale = employeeList.stream().collect(Collectors.partitioningBy(e->e.getGender().equalsIgnoreCase("male")));
////         var male =
//                 malefemale.entrySet().stream().filter(Map.Entry::getKey).forEach(e->System.out.println("male name list is : "+e.getValue().stream().map(Employee::getName).collect(Collectors.toList())));
//
//                 malefemale.entrySet().stream().filter(e-> !e.getKey()).forEach(e->System.out.println("female name list is"+e.getValue().stream().map(Employee::getName).collect(Collectors.toList())));




//        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

//        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
//                .entrySet().stream().forEach(System.out::println);


        //name of all the departmenst

//        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);


        //average age of male and female employees

//        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)))
//                .entrySet().stream().forEach(System.out::println);

        //highest paid employee in the organization

//        System.out.println(" max salary"+employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get());
//
//        employeeList.stream().max(Comparator.comparing(Employee::getSalary)).stream().collect(Collectors.toMap(Employee::getName,Employee::getSalary))
//                .entrySet().forEach(System.out::println);

        //names of all emloyees who joined after 2015

//        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015)
//                .map(Employee::getName).forEach(System.out::println);

        //count the number of employees in each department

//        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
//                .entrySet().stream().forEach(System.out::println);


        //youngest male candidate in product Development

//       var res = employeeList.stream().filter(e-> e.getGender().equalsIgnoreCase("male") && e.getDepartment().equalsIgnoreCase("Product Development"))
//                .min(Comparator.comparing(Employee::getAge)).map(Employee::getName);

//       System.out.println(res.orElse(" not found"));







    //how many male and female employees  in


//       var map =employeeList.stream().filter(e->e.getDepartment().equalsIgnoreCase("Product Development")).
//               collect(Collectors.groupingBy(e->e.getGender().equalsIgnoreCase("male"), Collectors.counting()));
//               map.entrySet().stream().filter(Map.Entry::getKey).forEach(e->System.out.println("male candtidates :"+e.getValue()));
//               map.entrySet().stream().filter(e->!e.getKey()).forEach(e->System.out.println("female candidates :"+e.getValue()));

     //list down employee names in department

//           employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment))
//
//                 .entrySet().stream().forEach(e->System.out.println( e.getKey()+ e.getValue().stream().map(Employee::getName).toList()));









//        Employee oldemp =employeeList.stream().max(Comparator.comparing(Employee::getAge)).get();
//
//        System.out.println(oldemp.getAge()+":"+oldemp.getDepartment());
//
//        var agepart = employeeList.stream().collect(Collectors.partitioningBy(e->e.getAge()>=25));
//
//        System.out.println("age >=25   :"+agepart.get(true));
//        System.out.println("age <25l :"+agepart.get(false));
//
//
//       var average = employeeList.stream().map(e->e.getSalary()).collect(Collectors.averagingDouble(e->e));
//          var sum=            employeeList.stream().mapToDouble(Employee::getSalary).sum();
//
//          System.out.println("sum is:"+sum+" avg is:"+average);
//
//         var avrasdouble= employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
//         System.out.println(avrasdouble);
//
//     var malefemale=    employeeList.stream().collect(Collectors.partitioningBy(e->e.getGender().equalsIgnoreCase("male")));
//
//
////     malefemale.entrySet().stream().filter(Map.Entry::getKey).mapToDouble(e->e.getValue().stream().map(e1->e1.getSalary())).average().getAsDouble()
//
////        System.out.println(employeeList.stream().map(Employee::getSalary).collect(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));
//
//        System.out.println(employeeList.stream().map(Employee::getSalary).limit(3).collect(Collectors.toList())
//                .stream().skip(2).collect(Collectors.toList()));
//
//
//        var sal = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList())
//        .stream().limit(3).skip(2).collect(Collectors.toList())
//        .stream().map(Employee::getSalary).collect(Collectors.toList());
//             System.out.println(sal);



    }




}


@FunctionalInterface
interface A{
    public void abc();
}

@FunctionalInterface
interface B extends A{
//    public void xyz();


}

class c implements B{

    @Override
    public void abc() {

    }
}
interface  E{    default void abc(){

}}


interface  F{
    default void abc(){

    }}


class D implements E,F{


    @Override
    public void abc() {
        System.out.println("abc");

        E.super.abc();
    }
}

