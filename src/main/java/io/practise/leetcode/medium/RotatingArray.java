package io.practise.leetcode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotatingArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        int pivot = 3;

        IntStream.range(0, nums.length - pivot)
                .boxed()
                .map(index -> nums[nums.length - pivot - index])
                .forEach(System.out::println);

        IntStream.range(pivot + 1, nums.length)
                .boxed()
                .map(index -> nums[nums.length - pivot - index - 1])
                .forEach(System.out::println);

    }

}
