package io.practise.dsa;

import java.util.*;

public class Subsets {

    // Backtracking - O(2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, nums, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets solver = new Subsets();
        int[] nums = {1, 2, 3};

        System.out.println("--- Subsets (Power Set) Demonstration ---");
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Subsets: " + solver.subsets(nums));
    }
}
