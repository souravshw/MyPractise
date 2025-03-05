package io.practise.myPractice;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeComparatorTest {

    public static void main(String[] args) {
        List<EmployeeTest> list = Arrays.asList(new EmployeeTest("A", 10, 200),
                new EmployeeTest("B", 10, 400),
                new EmployeeTest("B", 10, 400),
                new EmployeeTest("D", 10, 20));

        EmployeeTest em1 = new EmployeeTest("B", 10, 400);

        EmployeeTest em2 = new EmployeeTest("B", 10, 400);

        Map<EmployeeTest, Integer> map = new HashMap<>();

        map.put(em1, 1);

        map.put(em2, 3);

        System.out.println(map.size());


        System.out.println(list.stream().sorted(Comparator.comparing(EmployeeTest::getAge)
                        .thenComparing(EmployeeTest::getSalary).reversed())
                .collect(Collectors.toList()));
    }
}


class EmployeeTest {

    private String name;

    private int age;

    private int salary;

    public EmployeeTest(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EmployeeTest)) return false;
        EmployeeTest that = (EmployeeTest) o;
        return age == that.age && salary == that.salary && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }
}
