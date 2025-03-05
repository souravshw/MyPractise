package io.practise.hackerrank;

import java.util.Collections;
import java.util.HashSet;

import java.util.Map;
import java.util.stream.IntStream;

public class FindSumPair {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 9;

        HashSet<Integer> complements = new HashSet<>();

        System.out.println(IntStream.of(arr).anyMatch(num -> {
            if (complements.contains(num)) {
                return true;
            }
            complements.add(target - num);
            return false;
        }));


    }
}
