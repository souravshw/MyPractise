package io.practise.dsa;

import java.util.Arrays;

public class JumpGame {

    // Greedy - O(n)
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame solver = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println("--- Jump Game Demonstration ---");
        System.out.println("Array jumps: " + Arrays.toString(nums));
        System.out.println("Can reach last index: " + solver.canJump(nums));
    }
}
