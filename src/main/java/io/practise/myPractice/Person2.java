package io.practise.myPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class Person2 {
    private final String name;

    public Person2(String name) {
        this.name = new String(name);

    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public static void main(String[] args) {
        List<String> address = new ArrayList<>();
        address.add("BLR");
        address.add("MUMBAI");


        Person2 person2 = new Person2("Ravi");

        HashMap<Person2, Integer> map = new HashMap<>();

        map.put(person2, 1);
        map.put(new Person2("Ravi"), 2);
        map.put(new Person2("Puneeth"), 3);

        System.out.println(map.get(new Person2("Ravi")));

    }
}
