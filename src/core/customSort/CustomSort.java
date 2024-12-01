package core.customSort;

import java.util.ArrayList;
import java.util.Collections;

public class CustomSort {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ram",1,20,3234.45));
        employees.add(new Employee("Shyam",3,34,2500.45));
        employees.add(new Employee("Min",2,21,5000.50));
        employees.add(new Employee("Tin",4,20,6000));
        employees.add(new Employee("Pin",5,20,40000));

        //This sorting uses compareTo of Comparable Interface implemented by Employee Class
        Collections.sort(employees);

        System.out.println("Sort by ID:");
        for(Employee e : employees) System.out.println(e.toString());

        //This sorting uses compare method of Comparator Interface
        // reversed() can be used to reverse the sorting order
        employees.sort(new SalaryComparator().reversed());

        System.out.println("Sort by Salary");
        for(Employee e : employees) System.out.println(e.toString());

        //This sorting uses compare method of Comparator Interface
        employees.sort(new AgeComparator());

        System.out.println("Sort by Age");
        for(Employee e : employees) System.out.println(e.toString());

    }
}
