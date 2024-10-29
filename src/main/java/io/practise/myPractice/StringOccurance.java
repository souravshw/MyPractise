package io.practise.myPractice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class StringOccurance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int count = 0;
            Set<String> ss = new LinkedHashSet<String>();
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    String s = str.substring(i, j);
                    ss.add(s);
                }
            }
            System.out.println(ss);
            ArrayList<String> al = new ArrayList<String>();
            al.addAll(ss);
            for (int i = 0; i < al.size(); i++) {
                String s = al.get(i);
                int p = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (str.substring(j, j + 1).equals(s)) {
                        p++;
                    }
                }
                if (p > count)
                    count = p;
            }
            System.out.println(count);
        }
    }
}