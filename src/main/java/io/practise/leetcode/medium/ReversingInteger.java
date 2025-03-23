package io.practise.leetcode.medium;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x
 * causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
 * then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example:
 * Input: x = 123
 * Output: 321
 * <p>
 * <p>
 * Input: x = -123
 * Output: -321
 * <p>
 * Input: x = 123678
 * Output: 876321
 */
public class ReversingInteger {

    public static void main(String[] args) {
        int num = 123678;

        int ans = 0;

        for (; num > 0; num = num / 10) {

            if (ans <= Integer.MIN_VALUE / 10 || ans >= Integer.MAX_VALUE / 10) {
                ans = 0;
                break;
            }

            int temp = num % 10;
            ans = (ans * 10) + (temp);
        }

        System.out.println(ans);
    }
}
