package taxpayersexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//tradination way of sorting
 class MyComparator implements Comparator<EmployeeDTO>{

    @Override
    public int compare(EmployeeDTO o1, EmployeeDTO o2) {
        return o1.getSalary()-o2.getSalary();
    }
}

public class EmpComparator {
public static void main(String[] args){

    EmpDataBase empDataBase = new EmpDataBase();
    List<EmployeeDTO> list = new ArrayList<>();
    list = empDataBase.employeeBB();

    //sorting of objects using traditional way of collections
    Collections.sort(list, new MyComparator());
    System.out.println(" \n traditional way using Collections "+list);
    //sorting using FI and lambda expression

    Collections.sort(list, new Comparator<EmployeeDTO>() {
        @Override
        public int compare(EmployeeDTO o1, EmployeeDTO o2) {
            return o2.getSalary()-o1.getSalary();
        }
    });

    //simplified by lambda expression
    Collections.sort(list,(o1,o2)->o1.getSalary()-o2.getSalary());

    System.out.println(" \n using lamda expression sort the  Collections "+list);
    //using stream api sort method and foreach

    list.stream().sorted(new Comparator<EmployeeDTO>() {
        @Override
        public int compare(EmployeeDTO o1, EmployeeDTO o2) {
            return o1.getSalary()-o2.getSalary();
        }
    }).forEach(t->System.out.println("using steam api traditional lambda "+t));

    // using steam api sorted with lamda expression

    list.stream().sorted((o1,o2)->o2.getSalary()-o1.getSalary()).forEach(t->System.out.println("sorted using lambda with steam"+t));

    //using method reference sorting of an object

    list.stream().sorted(Comparator.comparing(EmployeeDTO::getSalary)).forEach(t->System.out.println("sort using method reference"+t));
}


}
