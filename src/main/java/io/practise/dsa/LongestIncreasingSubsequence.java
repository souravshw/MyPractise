package io.practise.dsa;

import java.util.*;

public class LongestIncreasingSubsequence {

    // DP with Binary Search - O(n log n)
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0) i = -(i + 1);
            if (i == sub.size()) sub.add(num);
            else sub.set(i, num);
        }
        return sub.size();
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solver = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println("--- Longest Increasing Subsequence Demonstration ---");
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Length of LIS: " + solver.lengthOfLIS(nums));
    }
}
