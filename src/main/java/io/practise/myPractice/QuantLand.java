package io.practise.myPractice;

import java.util.Scanner;

public class QuantLand {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int count[] = new int[t];
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();

      int a[] = new int[n];
      char ar[] = new char[n];
      String str = "";
      for (int a_i = 0; a_i < n; a_i++) {
        a[a_i] = in.nextInt();
        str = str.concat(Integer.toString(a[a_i]));
      }
      str = str.replace("000", "020");
      str = str.replace("0001", "0201");
      str = str.replace("1000", "1020");
      count[a0] = 0;
      ar = str.toCharArray();
      for (char ch : ar) {
        if (ch == '2')
          count[a0]++;
      }
    }
    for (int p : count)
      System.out.println(p);
  }
}
