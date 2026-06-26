package io.practise.dsa;

import java.util.*;

public class Permutations {

    // Backtracking - O(n!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) continue;
            path.add(num);
            backtrack(nums, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();
        int[] nums = {1, 2, 3};

        System.out.println("--- Permutations Demonstration ---");
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Permutations: " + solver.permute(nums));
    }
}
