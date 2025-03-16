package javaFI.java8;


import java.util.*;
import java.util.stream.Stream;

class StudentDatabase{

    public static List<StudentDto> studentDatabase(){
        List<StudentDto> studentDtos = new ArrayList<>();
        for(int i = 1; i<10;i++){
            studentDtos.add(new StudentDto(i,"name"+i, 100+i,"address"+i));
        }
        return studentDtos;
    }
}

class MyComparator implements Comparator<StudentDto> {

    @Override
    public int compare(StudentDto o1, StudentDto o2) {
//        return o1.getId()-o2.getId();
//        return o2.getId() - o1.getId();// descending order
        return o2.getName().compareTo(o1.getName());// ascending order based on name using compareTo method because its string
    }
}

class Mycomparator1 implements Comparator<StudentDto>{

    @Override
    public int compare(StudentDto o1, StudentDto o2) {
        return o2.getId()-o1.getId();
    }
}

public class ComparatorDemo {
    public static void main(String [] args){
    Mycomparator1 mycomparator1 = new Mycomparator1();

    List<StudentDto> list = StudentDatabase.studentDatabase();

    Collections.sort(list,mycomparator1);

        System.out.println("collection sort traditional way:["+list+"]");

    Collections.sort(list,(o1,o2)->o2.getId()-o1.getId());


    System.out.println("collection sort using lamda expression:["+list+"]");


list.stream().sorted((o1,o2)->o2.getId()-o1.getId()).forEach(x->System.out.println("usning stream api"+x));


















//        MyComparator myComparator = new MyComparator();
//
//        //step 1 : traditional way of sorting with new Mycomparator class
//        List<StudentDto> studentDtos = StudentDatabase.studentDatabase();
//
//        Collections.sort(studentDtos, new MyComparator());
//
//
//
//        System.out.println("List sorting using Collection sort method and providing my comparator"+studentDtos);
//
//        //step 2 : reducing few lines of code by elimintation separate class
//
//        Collections.sort(studentDtos, (s1,s2)-> s2.getId()-s1.getId() );
//
//        System.out.println("list of student data by using functional interface concept"+studentDtos);
//
//        //sorting using stream api
//        System.out.println("sorted method from stream api using custom comparator");
//        studentDtos.stream().sorted(new MyComparator()).forEach(t->System.out.println(t));
//
//        System.out.println("stream sorted method using Functional interface concept");
//
//        studentDtos.stream().sorted((s1,s2)->s1.getId()-s2.getId()).forEach(t->System.out.println(t));
//
//        System.out.println("stream sorted method using java 8 method reference");
//
//        studentDtos.stream().sorted(Comparator.comparing(StudentDto::getId).reversed())
//                .forEach(t->System.out.println(t));
//


    }
}
