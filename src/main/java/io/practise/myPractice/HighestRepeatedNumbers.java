package io.practise.myPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Get the highest repeated numbers by sorting order
 * Input = [3,5,7,3,5,20,3,4,7,11,5,3,4]
 * Output = [3,5,7,4,20,11]
 */
public class HighestRepeatedNumbers {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 3, 5, 20, 3, 4, 7, 11, 5, 3, 4};

        Arrays.sort(arr);

        Stream.of(arr).collect(Collectors.toSet());

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int a: arr) {
            int key = a;
            if(treeMap.get(key) != null) {
                int count = treeMap.get(key);
                treeMap.put(key,++count);
            } else {
                treeMap.put(a,1);
            }
        }

        System.out.println(treeMap);
    }

}
