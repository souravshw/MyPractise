package io.practise.myPractice;

import java.util.Scanner;

public class Emma {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Double k = in.nextDouble();
    int t = k.intValue();
    int ans = 0;
    int i;
    // your code goes here
    if (t == 1)
      System.out.println(1);
    else if (t % 2 == 0 && t > 1) {
      if (t > 2) {
        for (i = 2; i <= t / 2; i++) {
          ans = ans + (i * 2);
        }
        ans = ans + i + 1;
        System.out.println(ans);
      }
      if (t == 2)
        System.out.println(3);
    } else if (t > 1) {
      for (i = 2; i <= (t / 2 + 1); i++) {
        ans = ans + (i * 2);
      }
      ans = ans + 1;
      System.out.println(ans);
    }

  }
}
