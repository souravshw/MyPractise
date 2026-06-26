package io.practise.dsa;

public class LongestPalindromicSubstring {

    // Brute Force - O(n^3)
    public String longestPalindromeBrute(String s) {
        int maxLen = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > maxLen) {
                    result = sub;
                    maxLen = sub.length();
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }

    // Optimized - O(n^2) Expand Around Center
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i); // Odd length
            int len2 = expand(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solver = new LongestPalindromicSubstring();
        String s = "babad";

        System.out.println("--- Longest Palindromic Substring Demonstration ---");
        System.out.println("Input String: " + s);

        String result = solver.longestPalindrome(s);
        System.out.println("Longest Palindrome: " + result);
    }
}
