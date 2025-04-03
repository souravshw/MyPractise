package io.practise.accolite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalculateMinPossibleTime {

    public static void main(String[] args) {
        HashMap<String, Integer> personTimeMap = new HashMap<>();

        personTimeMap.put("A", 1);
        personTimeMap.put("B", 3);
        personTimeMap.put("G", 48);
        personTimeMap.put("E", 50);
        personTimeMap.put("F", 75);
        personTimeMap.put("C", 200);
        personTimeMap.put("D", 150);

        LinkedHashMap<String, Integer> linkedHashMap = sortMap(personTimeMap);


        System.out.println(linkedHashMap);


    }

    private static LinkedHashMap<String, Integer>  sortMap(HashMap<String, Integer> personTimeMap) {
        ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<>(personTimeMap.entrySet());

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        arrayList.stream().sorted(Map.Entry.comparingByValue()).forEach(eachEntry -> linkedHashMap.put(eachEntry.getKey(), eachEntry.getValue()));

        return linkedHashMap;
    }
}
