package io.practise.string;

import java.util.concurrent.Semaphore;

public class PrintOddEven {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        Semaphore semaphore2 = new Semaphore(2);

        Thread thread = new Thread(new EvenNumber(semaphore));

        Thread thread2 = new Thread(new OddNumber(semaphore2));

        thread.start();
        thread2.start();
    }
}

class EvenNumber implements Runnable {

    Semaphore semaphore;

    int number = 0;

    EvenNumber(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            number += 2;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(number);
        semaphore.release();
    }
}

class OddNumber implements Runnable {
    Semaphore semaphore;
    int number = 1;

    OddNumber(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            number += 2;
            System.out.println(number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(number);
        semaphore.release();
    }
}
