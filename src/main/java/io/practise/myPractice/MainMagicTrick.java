package io.practise.myPractice;

import java.util.Scanner;

public class MainMagicTrick {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String line = scan.next();
    int Test = Integer.parseInt(line);
    while (Test > 0) {
      int target = scan.nextInt();
      int x = checkMaxSum(target);
      int y = checkFinal(x, target);
      System.out.println(y);
      Test--;
    }
  }

  static int checkMaxSum(int n) {
    int sum = 0;
    for (int i = n - 1; i > 0; i--) {
      sum = i + (i - 2);
      if (sum == n)
        return i;
      else if (sum < n)
        return i + 1;
    }
    return 1;
  }

  static int checkFinal(int m, int target) {
    int sum = 0, max = m;
    for (int i = max; i > 0; i = i - 2) {
      sum += i;
      if (sum >= target) {
        max--;
        i = max + 2;
        sum = 0;
      }
    }
    return max + 1;
  }
}
