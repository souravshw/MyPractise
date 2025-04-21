package io.practise.accolite;

import java.util.HashMap;
import java.util.Map;

public class StringInMap {
    public static void main(String[] args) {
        String str = "A";
        String str1 = new String("A");

        Map<String, Integer> map = new HashMap<>();

        map.put(str,10);
        map.put(str1,20);

        System.out.println(map.size());
    }
}
