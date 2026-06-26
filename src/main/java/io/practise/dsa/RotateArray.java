package io.practise.dsa;

import java.util.Arrays;

public class RotateArray {

    // Brute Force - O(n * k)
    public void rotateBrute(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    // Optimized - O(n) with reversal
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        RotateArray solver = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("--- Rotate Array Demonstration ---");
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Rotate Right by: " + k);

        int[] testNums = nums.clone();
        System.out.println("\nExecuting Reversal-Based Rotation...");
        System.out.println("Step 1: Reverse entire array -> " + Arrays.toString(testNums));
        solver.reverse(testNums, 0, testNums.length - 1);
        System.out.println("  Result: " + Arrays.toString(testNums));
        
        System.out.println("Step 2: Reverse first k elements (0 to k-1) -> " + Arrays.toString(testNums));
        solver.reverse(testNums, 0, k - 1);
        System.out.println("  Result: " + Arrays.toString(testNums));
        
        System.out.println("Step 3: Reverse remaining elements (k to end) -> " + Arrays.toString(testNums));
        solver.reverse(testNums, k, testNums.length - 1);
        System.out.println("  Result: " + Arrays.toString(testNums));
    }
}
