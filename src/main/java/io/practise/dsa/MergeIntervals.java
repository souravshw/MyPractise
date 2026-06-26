package io.practise.dsa;

import java.util.*;

public class MergeIntervals {

    // Sort + Merge - O(n log n)
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        MergeIntervals solver = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println("--- Merge Intervals Demonstration ---");
        System.out.println("Input: " + Arrays.deepToString(intervals));
        System.out.println("Merged: " + Arrays.deepToString(solver.merge(intervals)));
    }
}
