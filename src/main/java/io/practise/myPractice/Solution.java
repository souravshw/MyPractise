package io.practise.myPractice;

import java.util.Scanner;

public class Solution {

  public static void main(String[] argh) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      String IP = in.next();
      System.out.println(IP.matches(new myRegex().pattern));
    }

  }
}

class myRegex {
  String pattern = "\\d\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d";

}