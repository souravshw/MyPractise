package io.practise.threads;

import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest extends RecursiveTask<Long> {

    private long number = 0;

    public ForkJoinPoolTest(long number) {
        this.number = number;
    }

    protected Long compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.number > 16) {
            System.out.println("Splitting workLoad : " + this.number);

            long firstNumber = this.number / 2;
            long secondNumber = this.number - firstNumber;

            ForkJoinPoolTest subtask1 = new ForkJoinPoolTest(firstNumber);
            ForkJoinPoolTest subtask2 = new ForkJoinPoolTest(secondNumber);

            subtask1.fork();
            subtask2.fork();

            long result = 0;
            result += subtask1.join();
            result += subtask2.join();
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.number);
            return number * 3;
        }
    }

    public static void main(String[] args) {
        ForkJoinPoolTest forkJoinPoolTest = new ForkJoinPoolTest(1000);

        forkJoinPoolTest.compute();
    }
}