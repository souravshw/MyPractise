package io.practise.map;

import java.util.*;

public class TestMapSorting {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Abhishek", 95);
        map.put("Sourav", 12);
        map.put("Prateek", 50);
        map.put("Sanu", 58);

        System.out.println("map clone " + map.clone());
        sortByValuesWithoutStream((Map<String, Integer>) map.clone());

        System.out.println("map clone " + map.clone());
        sortByvaluesWithStream((Map<String, Integer>) map.clone());

        // 1 3 6 9
        // Max diff between two consecuting element
        // if one element return 0
        // unique integers are present.
    }

    private static void sortByvaluesWithStream(Map<String, Integer> map) {

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    if (o1 > o2) {
                        return -1;
                    } else if (o1 < o2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }))
                .forEach(System.out::print);
    }

    private static void sortByValuesWithoutStream(Map<String, Integer> map) {

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, (o1, o2) -> {
            if (((Integer) ((Map.Entry) o1).getValue()) > ((Integer) ((Map.Entry) o2).getValue())) {
                return -1;
            } else if (((Integer) ((Map.Entry) o1).getValue()) < ((Integer) ((Map.Entry) o2).getValue())) {
                return 1;
            } else {
                return 0;
            }
        });

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        entries.forEach(eachEntry -> linkedHashMap.put(eachEntry.getKey(), eachEntry.getValue()));

        System.out.println(linkedHashMap);
    }
}
