package io.practise.dsa;

import java.util.*;

public class SlidingWindowMaximum {

    // Deque (Monotonic Queue) - O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solver = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("--- Sliding Window Maximum Demonstration ---");
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Result: " + Arrays.toString(solver.maxSlidingWindow(nums, k)));
    }
}
