package io.practise.myPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectEulerFibo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line = scan.next();

        // Starting the timer
        long startTime = System.nanoTime();

        int N = Integer.parseInt(line);
        ArrayList<Integer> fibo = new ArrayList<Integer>();
        fibo.add(1);
        fibo.add(2);
        int index = 1;
        int sum = 2;
        int latest = fibo.get(index - 1) + fibo.get(index);

        while (latest < N) {

            if (latest % 2 == 0)
                sum += latest;

            fibo.add(latest);
            index++;
            latest = fibo.get(index - 1) + fibo.get(index);
        }

        System.out.println(sum);

        // ending the Timer
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");
    }

}
