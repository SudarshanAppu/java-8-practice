package febPratice;

public class Employee4 {
    private int id;
    private String name;
    private String dept;
    private long salary;

    // Constructor, Getters and Setters
    public Employee4(int id, String name, String dept, long salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public long getSalary() {
        return salary;
    }
}