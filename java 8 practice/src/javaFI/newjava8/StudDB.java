package javaFI.newjava8;

import javaFI.java8.StudentDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyStudComparator implements Comparator<StudentDemoDto>{

    @Override
    public int compare(StudentDemoDto o1, StudentDemoDto o2) {
//return o2.getsId()-o1.getsId();
        return  o1.getsName().compareTo(o2.getsName());
    }
}

public class StudDB {

    public  static List<StudentDemoDto> studDB(){
        List<StudentDemoDto> list = new ArrayList<>();
        for(int i=1 ;i<11;i++){
            list.add(new StudentDemoDto(i,"name"+i, "address"+i));
        }
        return list;
    }

}
