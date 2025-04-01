package io.practise.accolite;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPool {
    private static final int CAPACITY = 10;
    private BlockingQueue<Runnable> allThreads;
    private final AtomicBoolean isShutDownInitiated;
    private static CustomThreadPool customThreadPoolInstance;
    private final Thread[] workers;


    private CustomThreadPool(boolean isShutdownInitiated) {

        this.isShutDownInitiated = new AtomicBoolean(isShutdownInitiated);

        this.allThreads = new LinkedBlockingQueue<>(CAPACITY);

        this.workers = new Thread[CAPACITY];

        for (int index = 0; index < CAPACITY; ++index) {
            workers[index] = new Worker(allThreads, isShutDownInitiated);
            workers[index].start();
        }
    }

    public static CustomThreadPool getInstance(boolean flag) {

        if (customThreadPoolInstance == null) {

            customThreadPoolInstance = new CustomThreadPool(flag);

        }

        return customThreadPoolInstance;
    }

    public void submitTask(Runnable task) {

        if (!isShutDownInitiated.get()) {
            allThreads.add(task);
        }

    }

    public static void main(String[] args) {

        CustomThreadPool customThreadPool = CustomThreadPool.getInstance(false);

        for (int index = 0; index < CAPACITY; ++index) {
            Task task = new Task("Task -- " + index);

            customThreadPool.submitTask(task);
        }

        customThreadPool.shutdown();
    }

    private void shutdown() {
        isShutDownInitiated.set(true);
        for (Thread worker : workers) {
            worker.interrupt();
        }
    }
}

class Worker extends Thread {

    private final BlockingQueue<Runnable> taskQueue;

    private final AtomicBoolean isShutDownInitiated;

    public Worker(BlockingQueue<Runnable> taskQueue, AtomicBoolean isShutDownInitiated) {
        this.taskQueue = taskQueue;
        this.isShutDownInitiated = isShutDownInitiated;
    }

    @Override
    public void run() {
        while (isShutDownInitiated.get() != true || !taskQueue.isEmpty()) {

            try {
                Runnable task = taskQueue.take();
                task.run();
            } catch (InterruptedException e) {
                if (isShutDownInitiated.get()) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}


class Task implements Runnable {

    private String taskName;

    public Task(String task) {
        this.taskName = task;
    }

    @Override
    public void run() {
        System.out.println("Task started !! " + taskName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Task Ended -- " + taskName);
    }
}


