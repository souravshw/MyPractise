package io.practise.dsa;

public class ClimbingStairs {

    // DP (Fibonacci style) - O(n), O(1) space
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs solver = new ClimbingStairs();
        int n = 5;

        System.out.println("--- Climbing Stairs Demonstration ---");
        System.out.printf("Number of steps: %d\n", n);
        System.out.println("Distinct ways: " + solver.climbStairs(n));
    }
}
