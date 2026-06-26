package io.practise.dsa;

import java.util.Arrays;

public class NonOverlappingIntervals {

    // Sort by end time - O(n log n)
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1], count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solver = new NonOverlappingIntervals();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

        System.out.println("--- Non-overlapping Intervals Demonstration ---");
        System.out.println("Input: " + Arrays.deepToString(intervals));
        System.out.println("Min intervals to remove: " + solver.eraseOverlapIntervals(intervals));
    }
}
