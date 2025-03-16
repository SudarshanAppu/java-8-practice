package taxpayersexample;

public class EmpDTo<T> {

    private T id;
    private T name;
    private T salary;

    public EmpDTo(T id, T name, T salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmpDTo() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getSalary() {
        return salary;
    }

    public void setSalary(T salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmpDTo{" +
                "id=" + id +
                ", name=" + name +
                ", salary=" + salary +
                '}';
    }
}
