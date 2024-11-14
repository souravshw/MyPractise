package io.practise.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * <p>
 * Example
 * <p>
 * The minimum sum is  and the maximum sum is . The function prints
 * <p>
 * 16 24
 * Function Description
 * <p>
 * Complete the miniMaxSum function in the editor below.
 * <p>
 * miniMaxSum has the following parameter(s):
 * <p>
 * arr: an array of  integers
 * Print
 * <p>
 * Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
 * <p>
 * Input Format
 * <p>
 * A single line of five space-separated integers.
 * <p>
 * Constraints
 * <p>
 * <p>
 * Output Format
 * <p>
 * Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
 * <p>
 * Sample Input
 * <p>
 * 1 2 3 4 5
 * Sample Output
 * <p>
 * 10 14
 * Explanation
 * <p>
 * The numbers are , , , , and . Calculate the following sums using four of the five integers:
 * <p>
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Sum everything except , the sum is .
 * Hints: Beware of integer overflow! Use 64-bit Integer.
 */
public class MinMaxSum {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }


    public static void miniMaxSum(List<Integer> arr) {

        int minValue = arr.stream().reduce(arr.get(0), (min, element) -> {
            if (min > element) {
                min = element;
            }
            return min;
        }).intValue();

        int totalSum = arr.stream().reduce(0, (sum, element) -> {
            sum += element;
            return sum;
        }).intValue();

        int maxValue = arr.stream().reduce(arr.get(0), (max, element) -> {
            if (max < element) {
                max = element;
            }
            return max;
        }).intValue();

        System.out.println(maxValue + " " + minValue+" "+totalSum);
        System.out.println((totalSum - maxValue) + " " + (totalSum - minValue));

    }

}
