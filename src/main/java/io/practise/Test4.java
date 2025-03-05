package io.practise;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//What is right implementation of Key in the HashMap.

public class Test4 {

    public static void main(String[] args) {

        Employee employee1 = new Employee("A", "1", new Date());
        Employee employee2 = new Employee("B", "2", new Date());
        Employee employee3 = new Employee("C", "3", new Date());

        Map<Employee, Integer> map = new HashMap<>();

        map.put(employee1, 1);
        map.put(employee2, 2);
        map.put(employee3, 3);

        System.out.println(map);
    }
}

final class Employee {
    private final String name;
    private final String id;
    private final Date doj;

    Employee(String name, String id, Date doj) {
        this.name = name;
        this.id = id;
        this.doj = (Date) doj.clone();
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public Date getDoj() {
        return (Date) this.doj.clone();
    }

    public String toString() {
        return "Employee [name=" + this.name + ", id=" + this.id + ", doj=" + this.doj + "]";
    }

    public boolean equals(Object emp) {
        if (!(emp instanceof Employee)) {
            return false;
        } else if (emp == null) {
            return false;
        } else {
            Employee emp2 = (Employee) emp;
            return Objects.equals(this.name, emp2.getName()) && Objects.equals(this.id, emp2.getId()) && Objects.equals(this.doj, emp2.getDoj());
        }
    }
}