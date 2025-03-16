package febPratice;

import java.util.List;

public class Student {

    Integer student_id;

    public Student(Integer student_id, String name, List<Integer> deptIds) {
        this.student_id = student_id;
        this.name = name;
        this.deptIds = deptIds;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Integer> deptIds) {
        this.deptIds = deptIds;
    }

    String name ;


    List<Integer> deptIds;


}
