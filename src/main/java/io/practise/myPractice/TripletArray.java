package io.practise.myPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array arr[] of size n and an integer sum. Find if there’s a triplet in the array which sums up to the given integer sum.
 * Examples:
 * Input: arr = {12, 3, 4, 1, 6, 9}, sum = 24;
 * Output: 12, 3, 9
 * Explanation: There is a triplet (12, 3 and 9) present
 * in the array whose sum is 24.
 * Input: arr = {1, 2, 3, 4, 5}, sum = 9
 * Output: 5, 3, 1
 * Explanation: There is a triplet (5, 3 and 1) present
 * in the array whose sum is 9.
 * Input: arr = {2, 10, 12, 4, 8}, sum = 9
 * Output: No Triplet
 * Explanation: We do not print in this case and return false.
 */
public class TripletArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int targetSum = 9;

        System.out.println(isTripletPresent(arr, targetSum));
    }

    private static boolean isTripletPresent(int[] arr, int targetSum) {

        List<Integer> elementList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        for (int index = 0; index < arr.length; ++index) {

            int firstElement = arr[index];

            if (firstElement < targetSum) {
                int difference = targetSum - firstElement;

                int finalDifference = 0;

                for (int secondElement = index + 1; secondElement < arr.length; ++secondElement) {

                    if (secondElement < difference) {
                        finalDifference = difference - arr[secondElement];

                        if (elementList.contains(finalDifference)) {
                            return true;
                        }


                    }
                }

            }

        }

        return false;
    }
}
