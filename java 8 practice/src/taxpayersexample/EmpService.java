package taxpayersexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmpService {


public static List<EmployeeDTO> empList(String tax){

    EmpDataBase empDataBase = new EmpDataBase();

   return tax.equalsIgnoreCase("tax")?
    empDataBase.employeeBB().stream().filter(t->t.getSalary()>500000).collect(Collectors.toList()):
           empDataBase.employeeBB().stream().filter(t->t.getSalary()<=500000).collect(Collectors.toList());
}




}
