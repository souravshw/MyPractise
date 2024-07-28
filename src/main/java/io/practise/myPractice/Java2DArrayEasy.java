package io.practise.myPractice;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Java2DArrayEasy {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arr[][] = new int[6][6];
    int sum = 0;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        arr[i][j] = in.nextInt();
      }
    }
    SortedSet<Integer> ts = new TreeSet<Integer>();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
        ts.add(sum);
      }
    }
    System.out.println(ts.last());
  }
}