package core.customSort;
/*

    The Comparable interface is used to define the "natural ordering" of objects in a class.
    It is implemented by the class itself.
    Contains a single method: int compareTo(T o); when this > o then +ve, when this < o then -ve else 0(equal)

 */
public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;
    private double salary;

    @Override
    public int compareTo(Employee e){
        return Integer.compare(this.id,e.id);
    }

    @Override
    public String toString(){
        return id+" "+this.name+" "+this.age+" "+this.salary;
    }

    public Employee(String name, int id, int age, double salary) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

