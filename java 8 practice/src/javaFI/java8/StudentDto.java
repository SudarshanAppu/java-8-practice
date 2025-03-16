package javaFI.java8;

public class StudentDto {

    public StudentDto(int id, String name, int marks, String address) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.address = address;
    }

    private int id;
    private String name;
    private int marks;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", address='" + address + '\'' +
                '}';
    }
}
