package io.practise.accolite;

import java.util.HashSet;
import java.util.Set;

public class SubArraysWithZeroSumExists {


    public static void main(String[] args) {
        int[] nums = {4, 1, -6, 3, -1, 4, 2, 7};

        Set<Integer> sumSet = new HashSet<>();

        sumSet.add(0);

        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (sumSet.contains(sum)) {
                System.out.println(true);
                break;
            }

            sumSet.add(sum);
        }
    }
}
