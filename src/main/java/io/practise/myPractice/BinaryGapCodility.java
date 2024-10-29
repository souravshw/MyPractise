package io.practise.myPractice;

import java.util.Scanner;

public class BinaryGapCodility {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BinaryGapCodility output = new BinaryGapCodility();
        int gap = output.solution(N);
        System.out.println(gap);
    }

    public int solution(int N) {
        String str = Integer.toBinaryString(N);
        System.out.println(str);
        char[] arr = str.toCharArray();
        int o = 0;
        int large = 0;
        for (int t = 1; t < str.length(); t++) {
            System.out.print(" " + arr[t]);
            if (arr[t] == '1') {
                int temp = t - o - 1;
                System.out.println(" " + temp + " hello");
                if (temp > large)
                    large = temp;
                o = t;
            }
        }
        System.out.println();
        return large;
    }
}
