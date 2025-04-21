package io.practise.accolite;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PrintOddEvenUsingTwoThreads {
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(20);

        OddNumber oddNumber = new OddNumber(blockingQueue);
        EvenNumber evenNumber = new EvenNumber(blockingQueue);

        new Thread(oddNumber).start();
        new Thread(evenNumber).start();

    }
}

class OddNumber implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    static int number = 1;

    public OddNumber(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {

            for (int index = 0; index < 20; ++index) {
                blockingQueue.put(number);

                System.out.println("Odd Number " + number);

                number += 2;
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class EvenNumber implements Runnable {

    int number = 2;

    private BlockingQueue<Integer> blockingQueue;

    public EvenNumber(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer take = blockingQueue.take();
                take++;
                System.out.println("Even Number " + take);

                if (take == 20) {
                    break;
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
