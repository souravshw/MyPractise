package io.practise.string;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EvenOddUsingBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);

        new Thread(new OddNumber1(blockingQueue)).start();
        new Thread(new EvenNumber2(blockingQueue)).start();

    }
}

class OddNumber1 implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    static int counter = 0;

    public OddNumber1(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                counter += 2;
                int output = counter - 1;
                System.out.println("OddNumber " + output);
                blockingQueue.put(output);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class EvenNumber2 implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public EvenNumber2(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int counter = blockingQueue.take();
                int output = counter - 1;
                System.out.println("EvenNumber " + output);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
