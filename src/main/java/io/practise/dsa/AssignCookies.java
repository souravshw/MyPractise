package io.practise.dsa;

import java.util.Arrays;

public class AssignCookies {

    // Sort + Two Pointers - O(n log n)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        AssignCookies solver = new AssignCookies();
        int[] g = {1, 2, 3}; // children greed
        int[] s = {1, 1};    // cookies size

        System.out.println("--- Assign Cookies Demonstration ---");
        System.out.println("Children greed: " + Arrays.toString(g));
        System.out.println("Cookies size: " + Arrays.toString(s));
        System.out.println("Content children: " + solver.findContentChildren(g, s));
    }
}
