package io.practise.dsa;

import java.util.*;

public class GroupAnagrams {

    // Brute Force - O(n^2 * k log k)
    public List<List<String>> groupAnagramsBrute(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            res.add(group);
        }
        return res;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) if (c != 0) return false;
        return true;
    }

    // Optimized - O(n * k log k) with HashMap
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solver = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("--- Group Anagrams Demonstration ---");
        System.out.println("Input: " + Arrays.toString(strs));

        List<List<String>> result = solver.groupAnagrams(strs);
        System.out.println("Grouped Anagrams: " + result);
    }
}
