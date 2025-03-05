package io.practise.string;

import java.util.concurrent.Semaphore;

/**
 * Took help from baeldung.com
 * https://www.baeldung.com/java-even-odd-numbers-with-2-threads
 */
public class TestOddEvenThroughThreads {


    private Semaphore semEven = new Semaphore(0);
    private Semaphore semOdd = new Semaphore(1);

    void printEvenNum(int num) {
        try {
            semEven.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + num);
        semOdd.release();
    }

    void printOddNum(int num) {
        try {
            semOdd.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + num);
        semEven.release();

    }

    public static void main(String[] args) {
        TestOddEvenThroughThreads sp = new TestOddEvenThroughThreads();
        Thread odd = new Thread(new Odd(sp, 10), "Odd ");
        Thread even = new Thread(new Even(sp, 10), "Even ");
        odd.start();
        even.start();
    }
}

class Even implements Runnable {
    private TestOddEvenThroughThreads sp;
    private int max;

    public Even(TestOddEvenThroughThreads sp, int i) {
        this.sp = sp;
        this.max = i;
    }

    @Override
    public void run() {
        for (int i = 2; i <= max; i = i + 2) {
            sp.printEvenNum(i);
        }
    }
}

class Odd implements Runnable {
    private TestOddEvenThroughThreads sp;
    private int max;

    public Odd(TestOddEvenThroughThreads sp, int i) {
        this.sp = sp;
        this.max = i;
    }

    @Override
    public void run() {
        for (int i = 1; i <= max; i = i + 2) {
            sp.printOddNum(i);
        }
    }
}
