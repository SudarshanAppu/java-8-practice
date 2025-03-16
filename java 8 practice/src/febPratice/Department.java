package febPratice;

public class Department {
    public Department(Integer departmentId, String deptName) {
        this.departmentId = departmentId;
        this.deptName = deptName;
    }

    Integer departmentId;

    String deptName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}