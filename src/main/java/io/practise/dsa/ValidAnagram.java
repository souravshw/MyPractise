package io.practise.dsa;

import java.util.Arrays;

public class ValidAnagram {

    // Brute Force - O(n log n) by sorting
    public boolean isAnagramBrute(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // Optimized - O(n) with character count array
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();
        String s = "anagram", t = "nagaram";

        System.out.println("--- Valid Anagram Demonstration ---");
        System.out.printf("String 1: %s, String 2: %s\n", s, t);

        boolean result = solver.isAnagram(s, t);
        System.out.println("Step 1: Compare lengths. Both are length " + s.length());
        System.out.println("Step 2: Maintain frequency count arrays.");
        System.out.println("Is Anagram: " + result);
    }
}
