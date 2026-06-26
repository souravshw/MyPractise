package io.practise.dsa;

import java.util.*;

public class PalindromePartitioning {

    // Backtracking + isPalindrome
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, String s, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String substr = s.substring(start, end);
            if (isPalindrome(substr)) {
                path.add(substr);
                backtrack(end, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solver = new PalindromePartitioning();
        String s = "aab";

        System.out.println("--- Palindrome Partitioning Demonstration ---");
        System.out.println("String: " + s);
        System.out.println("Partitions: " + solver.partition(s));
    }
}
