package io.practise.dsa;

import java.util.Arrays;

public class HouseRobber {

    // DP - O(n), O(1) space
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber solver = new HouseRobber();
        int[] houses = {2, 7, 9, 3, 1};

        System.out.println("--- House Robber Demonstration ---");
        System.out.println("Houses loot values: " + Arrays.toString(houses));
        System.out.println("Max loot possible: " + solver.rob(houses));
    }
}
