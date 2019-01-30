import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Employee{
    private int empid;
    private double salary;
    private String name;

    @Contract(pure = true)
    public Employee(int empid, double salary, String name) {
        this.empid = empid;
        this.salary = salary;
        this.name = name;
    }

    public Employee(){

    }

    public int getEmpid() {
        return empid;
    }

    public double getSalary() {
        return salary;
    }

    public void get() {
        Scanner in = new Scanner(System.in);
        System.out.println("Name    : ");
        name = in.nextLine();

        System.out.println("Empid   : ");
        empid = in.nextInt();

        System.out.println("Salary  : ");
        salary = in.nextDouble();
        //in.close();
    }

    public String toString() {
        return ("[ Name : " + name + "Empid : " + empid + "Salary : " + salary + "]");
    }
}

class Comp implements Comparator<Employee> {

    @Override
    public int compare(Employee employee, Employee t1) {
        if(employee.getEmpid() != t1.getEmpid())
            return employee.getEmpid() - t1.getEmpid();
        return (int) (employee.getSalary() - t1.getSalary());
    }
}

public class SortArraylist {
    public static void main(String[] args) {
        ArrayList<Employee> list= new ArrayList<Employee>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of records : ");
        int n;
        n = in.nextInt();
        for(int i = 0; i < n; ++i) {
            Employee e = new Employee();
            e.get();
            list.add(e);
        }
        Collections.sort(list, new Comp());
        for(int i = 0; i < n; ++i) {
            System.out.println(list.get(i).toString());
        }
        in.close();
    }
}
