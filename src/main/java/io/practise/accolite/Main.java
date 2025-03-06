package io.practise.accolite;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        TestTest ob1 = new TestTest("A");

        TestTest ob2 = new TestTest("A");

        HashMap<TestTest, String> map = new HashMap<>();

        map.put(ob1,ob1.getName());
        map.put(ob2,ob2.getName());

        System.out.println(map);
    }
}

class TestTest {
    private String name;

    TestTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "TestTest{" +
                "name='" + name + '\'' +
                '}';
    }
}