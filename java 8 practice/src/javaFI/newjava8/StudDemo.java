package javaFI.newjava8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudDemo {

    public static void main(String args[]){
        List<StudentDemoDto> list = new ArrayList<>();
        list = StudDB.studDB();
        MyStudComparator myStudComparator = new MyStudComparator();
        System.out.println(" list Stud DB"+list);

//        Collections.sort(list, new MyStudComparator());


        Collections.sort(list , new MyStudComparator() );
        System.out.println("list default sort"+list);

        list.stream().sorted(new MyStudComparator()).forEach(x->System.out.println(x));
//        list.stream().flatMap(new MyStudComparator()).forEach();


     List<StudentDemoDto>  list1 = new ArrayList<>();

     list1 = StudDB.studDB();

     Collections.sort(list1, Comparator.comparing(StudentDemoDto::getsName));

     System.out.println(" list 1 is :"+list1);

     List<StudentDemoDto> res = list.stream().sorted((o1, o2) -> o2.getsName().compareTo(o1.getsName())).collect(Collectors.toList());

System.out.println(res);

    }
}
