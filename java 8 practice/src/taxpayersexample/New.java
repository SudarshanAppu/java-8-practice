package taxpayersexample;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class MyComparable implements  Comparable<EmployeeDTO>{

    EmployeeDTO employeeDTO = new EmployeeDTO();

    @Override
    public int compareTo(EmployeeDTO o) {
        return employeeDTO.getId()-o.getId();
    }
}
public class New {

    public  static  void main(String [] args){
        List<EmployeeDTO> list = EmpDataBase.employeeBB();

        Collections.sort(list, (o1, o2) -> o2.getName().compareTo(o1.getName()));

        System.out.println(list);
        var list1 = list.stream().sorted((o1,o2)->o2.getName().compareTo(o1.getName())).collect(Collectors.toList());

        System.out.println(list1);
    }
}
