package io.practise.accolite;

import java.util.LinkedList;

public class ProducerConsumerWithoutBlockingQueue {

    public static void main(String[] args) {

        LinkedList<Integer> buffer = new LinkedList<>();

        new Thread(new Producer(buffer)).start();

        new Thread(new Consumer(buffer)).start();
    }
}

class Producer implements Runnable {

    private LinkedList<Integer> buffer;

    private final int maxBuffer = 10;

    private static int counter = 0;

    public Producer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() == maxBuffer) {
                        buffer.wait();
                    }

                    if (buffer.size() < maxBuffer) {

                        buffer.add(++counter);

                        System.out.println("Produced an item: " + counter);

                        buffer.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer implements Runnable {

    private LinkedList<Integer> buffer;

    private final int maxBuffer = 10;

    public Consumer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {

                synchronized (buffer) {

                    while (buffer.size() == 0) {
                        buffer.wait();
                    }

                    if (!buffer.isEmpty()) {

                        Integer num = buffer.removeFirst();

                        System.out.println("Consumed an item: " + num);

                        buffer.notifyAll();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
