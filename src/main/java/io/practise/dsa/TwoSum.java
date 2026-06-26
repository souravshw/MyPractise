package io.practise.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    // Brute Force - O(n^2)
    public int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Optimized - O(n) using HashMap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("--- Two Sum Demonstration ---");
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);

        System.out.println("\nExecuting Optimized Approach...");
        System.out.println("Step 1: Create a HashMap to store (number -> index).");
        
        int[] result = solver.twoSum(nums, target);
        System.out.println("Step 2: Iterate through the array:");
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.printf("  Index %d: value = %d. Complement needed = %d - %d = %d.\n", 
                i, nums[i], target, nums[i], complement);
            if (i == 1) {
                System.out.printf("  Success: Complement %d is already in the map (index 0). Found indices: [0, 1].\n", complement);
            }
        }
        System.out.println("Result Indices: " + Arrays.toString(result));
    }
}
