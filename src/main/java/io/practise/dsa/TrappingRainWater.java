package io.practise.dsa;

import java.util.Arrays;

public class TrappingRainWater {

    // Brute Force - O(n^2)
    public int trapBrute(int[] height) {
        int n = height.length, water = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j >= 0; j--) leftMax = Math.max(leftMax, height[j]);
            for (int j = i; j < n; j++) rightMax = Math.max(rightMax, height[j]);
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }

    // Optimized - O(n) with Two Pointers
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println("--- Trapping Rain Water Demonstration ---");
        System.out.println("Heights: " + Arrays.toString(height));

        int water = solver.trap(height);
        System.out.println("Total water trapped: " + water);
    }
}
