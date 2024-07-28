package io.practise.myPractice;

import java.util.Scanner;

public class ZeroIndexedArrayCodility {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] arr = new int[N];
    for (int h = 0; h < N; h++)
      arr[h] = sc.nextInt();

    ZeroIndexedArrayCodility output = new ZeroIndexedArrayCodility();
    int out = output.solution(arr);
    System.out.println(out);
  }

  public int solution(int[] A) {
    // write your code in Java SE 8
    String str = "";
    boolean find = true;
    for (int i = 0; i < A.length; i++) {
      str = str.concat(Integer.toString(A[i]));

      //	if (!str.contains(ar))
      find = false;
    }

    return 0;
  }

}
