package io.practise.dsa;

import java.util.Arrays;

public class MoveZeroes {

    // Brute Force - O(n) with extra space
    public void moveZeroesBrute(int[] nums) {
        int[] temp = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                temp[index++] = num;
            }
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    // Optimized - O(n) in-place
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solver = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("--- Move Zeroes Demonstration ---");
        System.out.println("Input Array: " + Arrays.toString(nums));

        System.out.println("\nExecuting In-Place Shift...");
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                System.out.printf("  Found non-zero %d. Writing to insertPos %d.\n", num, insertPos);
                insertPos++;
            }
        }
        System.out.printf("  Filling remaining spots from index %d to %d with 0.\n", insertPos, nums.length - 1);
        
        int[] testNums = {0, 1, 0, 3, 12};
        solver.moveZeroes(testNums);
        System.out.println("Result Array: " + Arrays.toString(testNums));
    }
}
