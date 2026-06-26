package io.practise.dsa;

import java.util.Arrays;

public class MaximumSubarray {

    // Brute Force - O(n^2)
    public int maxSubArrayBrute(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // Optimized - O(n) (Kadane's Algorithm)
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solver = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("--- Maximum Subarray (Kadane's) Demonstration ---");
        System.out.println("Input Array: " + Arrays.toString(nums));

        System.out.println("\nExecuting Kadane's Algorithm...");
        int maxSum = nums[0], currSum = nums[0];
        System.out.printf("Initial state: currSum = %d, maxSum = %d\n", currSum, maxSum);
        
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            System.out.printf("After element %d (val=%d): currSum = %d, maxSum = %d\n", 
                i, nums[i], currSum, maxSum);
        }
        System.out.println("Maximum contiguous subarray sum: " + solver.maxSubArray(nums));
    }
}
