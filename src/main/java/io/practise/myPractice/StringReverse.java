package io.practise.myPractice;

import java.util.Scanner;

public class StringReverse {

  public static void main(String[] args) {
    String A = new Scanner(System.in).next();
    String rev = "";
    for (int i = A.length(); i > 0; i--)
      rev = rev.concat(A.substring(i - 1, i));
    if (A.compareTo(rev) != 0)
      System.out.println("No");
    else
      System.out.println("Yes");
  }
}
