package io.practise.accolite;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerWithBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);

        new Thread(new Producer1(blockingQueue)).start();

        new Thread(new Consumer1(blockingQueue)).start();
    }
}

class Producer1 implements Runnable {

    private BlockingQueue<Integer> blockingQueue;
    private static int count = 0;

    public Producer1(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                blockingQueue.put(++count);

                System.out.println("Produced item: " + count);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Consumer1 implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public Consumer1(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer count = blockingQueue.take();

                System.out.println("Consumed item: " + count);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
