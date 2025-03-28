package io.practise.accolite;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeSecond {
    private String name;
    private Integer id;

    public EmployeeSecond(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public static void main(String[] args) {
        List<EmployeeSecond> list = Arrays.asList(new EmployeeSecond("Sourav", 5),
                new EmployeeSecond("Test", 6),
                new EmployeeSecond("Sourav", 3),
                new EmployeeSecond("Test", 4));

        list.stream().sorted(Comparator.comparing(EmployeeSecond::getName).thenComparing(EmployeeSecond::getId)).forEach(System.out::println);
    }
}
