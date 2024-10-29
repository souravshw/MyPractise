package io.practise.myPractice;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class StringCompare {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        String A = sc.next();
        int k = sc.nextInt();
        SortedSet<String> ts = new TreeSet<String>();
        for (int i = 0; i <= A.length() - k; i++)
            ts.add(A.substring(i, i + k));
        System.out.println(ts.first() + "\n" + ts.last());
    }
}
