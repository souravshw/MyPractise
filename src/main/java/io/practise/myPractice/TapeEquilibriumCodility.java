package io.practise.myPractice;

import java.util.Scanner;

public class TapeEquilibriumCodility {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int h = 0; h < N; h++)
            arr[h] = sc.nextInt();

        TapeEquilibriumCodility output = new TapeEquilibriumCodility();
        int out = output.solution(arr);
        System.out.println(out);

    }

    public int solution(int[] A) {
        Integer min = null;
        int diff = 0, pre = A[0], suf = 0;

        for (int i = 1; i < A.length; i++) {
            suf += A[i];
        }

        diff = pre - suf;
        if (diff < 0)
            diff *= -1;
        min = diff;
        for (int j = 2; j < A.length; j++) {
            pre += A[j - 1];
            suf -= A[j - 1];
            diff = pre - suf;
            if (diff < 0)
                diff *= -1;

            if (min > diff) {
                min = diff;
            }
        }
        return min;
    }

}
