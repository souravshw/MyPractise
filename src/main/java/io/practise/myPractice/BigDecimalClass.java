package io.practise.myPractice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

class BigDecimalClass {

    public static void main(String[] argh) {
        // Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n + 2];
        ArrayList<String> al = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
            al.add(str[i]);
        }

        for (int i = 0; i < al.size() - 1; i++) {
            for (int j = 1; j < al.size() - i; j++) {

                BigDecimal b1 = new BigDecimal(al.get(j - 1));
                BigDecimal b2 = new BigDecimal(al.get(j));
                //System.out.println(b1+" "+b2);
                if (b1.compareTo(b2) < 0) {
                    String temp = al.get(j - 1);
                    al.set(j - 1, al.get(j));
                    al.set(j, temp);
                } else if (b1.compareTo(b2) == 0) {
                    if (str[i].substring(0, 1).equals(".")) {
                        String temp = al.get(j - 1);
                        al.set(j - 1, al.get(j));
                        al.set(j, temp);
                    } else if (str[j].substring(0, 1).equals(".")) {
                        String temp = al.get(j - 1);
                        al.set(j - 1, al.get(j));
                        al.set(j, temp);
                    }

                }

            }
        }

        // Output
        for (int i = 0; i < n; i++) {
            System.out.println(al.get(i));
        }
    }

}
