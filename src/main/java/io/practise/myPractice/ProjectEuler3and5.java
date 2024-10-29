package io.practise.myPractice;

import java.util.Scanner;

public class ProjectEuler3and5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.next();

        // Starting the timer
        long startTime = System.nanoTime();

        long N = Long.parseLong(line);
        long sum = 0;

        long N3 = (N > 3) ? returnBestThreeDivisibilityNumber(N) / 3 : 0;
        long N5 = (N > 5) ? retunbestFiveDivisibilityNumber(N) / 5 : 0;
        long N15 = (N > 15) ? retunbestFifteenDivisibilityNumber(N) / 15 : 0;

        sum = (N3 * (2 * 3 + (N3 - 1) * 3) / 2) + (N5 * (2 * 5 + (N5 - 1) * 5) / 2)
                - (N15 * (2 * 15 + (N15 - 1) * 15) / 2);

        System.out.println(sum);

        // ending the Timer
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");
    }

    static long returnBestThreeDivisibilityNumber(long n) {
        n--;
        while (n % 3 != 0)
            n--;
        return n;
    }

    static long retunbestFiveDivisibilityNumber(long n) {
        n--;
        while (n % 5 != 0)
            n--;
        return n;
    }

    static long retunbestFifteenDivisibilityNumber(long n) {
        n--;
        while (n % 15 != 0)
            n--;
        return n;
    }
}
