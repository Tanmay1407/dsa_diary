package core.customSort;
import java.util.Comparator;

/*

    The Comparator interface is used to define custom sorting logic, external to the class being sorted.
    Contains a single method:int compare(T o1, T o2);
        returns +ve if o1 > o2
        returns -ve if o1 < o2
        else returns 0

    Used when multiple sorting strategies are required or when the class cannot be modified to implement Comparable.

*/

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        if(e1.getSalary() > e2.getSalary()) return 1;
        else if(e1.getSalary() < e2.getSalary()) return -1;
        else return 0;
    }
}
