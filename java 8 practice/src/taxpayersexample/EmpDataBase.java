package taxpayersexample;

import java.util.ArrayList;
import java.util.List;

public class EmpDataBase {
    public static List<EmployeeDTO> employeeBB(){
        List<EmployeeDTO> list = new ArrayList<>();

        list.add(new EmployeeDTO(1,"moni",500000));
        list.add(new EmployeeDTO(2,"abhi", 700000));
        list.add(new EmployeeDTO(3,"appu", 400000));
        list.add(new EmployeeDTO(4,"jack",600000));

        return list;

    }
}
