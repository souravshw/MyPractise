package io.practise.myPractice;

import java.util.Scanner;

public class Java1DArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int negative = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = 0, p = 0;
                for (int k = j; k < n && k <= j + i - 1; k++, p++) {
                    sum += arr[k];

                }
                if (p < i)
                    sum = 0;
                else if (sum < 0)
                    negative++;
            }
        }
        System.out.println(negative);
    }

}
