package io.practise.accolite;


import java.util.*;

public class Example {
    public static void main(String[] args) {
        Map<Integer, TestEmployee> salaryEmployeeMap = new HashMap<>();

        TestEmployee te1 = new TestEmployee(500, "Sourav1", 1);
        TestEmployee te2 = new TestEmployee(800, "Sourav2", 2);
        TestEmployee te3 = new TestEmployee(200, "Sourav3", 3);
        TestEmployee te4 = new TestEmployee(900, "Sourav4", 4);

        salaryEmployeeMap.put(te1.getSalary(), te1);
        salaryEmployeeMap.put(te2.getSalary(), te2);
        salaryEmployeeMap.put(te3.getSalary(), te3);
        salaryEmployeeMap.put(te4.getSalary(), te4);

        Map<String, Integer> output = sortBasedOnValues(salaryEmployeeMap);

        System.out.println(output);
    }

    private static Map<String, Integer> sortBasedOnValues(Map<Integer, TestEmployee> salaryEmployeeMap) {

        LinkedHashMap<String, Integer> output = new LinkedHashMap<>();

        salaryEmployeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue((o1, o2) -> {
            return Integer.compare(o2.getSalary(), o1.getSalary());
        })).forEach(eachEntry -> output.put(eachEntry.getValue().getName(), eachEntry.getValue().getSalary()));

        return output;
    }

}

class TestEmployee {
    private int salary;
    private String name;
    private int id;

    public TestEmployee(int salary, String name, int id) {
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "TestEmployee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
