package javaFI.java8interview;

public class Employee3 {
    private int id;
    private String name;
    private String dept;
    private long salary;

    // Constructor, Getters and Setters
    public Employee3(int id, String name, String dept, long salary) {
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
