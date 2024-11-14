package io.practise.myPractice;

import java.util.Arrays;

/**
 * Find missing numbers
 * Input: arr[] = {4, 3, 6, 2, 1, 1}
 * {1,1,2,3,4,6}
 * Min 1
 * Max 6
 * Output: Missing = 5
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1, 4, 8};

        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[arr.length - 1];

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] == 0 || arr[i] - arr[i - 1] == 1) {
                continue;
            } else {
                System.out.println(arr[i - 1] + 1);
            }
        }

    }
}
