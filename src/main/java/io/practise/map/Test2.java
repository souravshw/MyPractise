package io.practise.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        List<?> test = new ArrayList<>();
        List<Object> test2 = new ArrayList<>();

        test = test2;

        List<A> testA = new ArrayList<>();

        List<? extends A> testAA = new ArrayList<>();

        List<? extends B> testB = new ArrayList<>();

        testAA = testB;


        Map<Test, String> map = new HashMap<>();
        Test t1 = new Test("asdf");
        Test t2 = new Test("asdf");
        map.put(t1, "Hi");
        System.out.println(map.get(t2));

        addStrings(test2);

    }

    public static void addStrings(List list) {
        list.add("foo");
        list.add("bar");
    }

}

class Test {
    String str;

    Test(String str) {
        this.str = str;
    }
}

