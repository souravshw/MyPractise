package io.practise.accolite;

public class UnderstandingSynchronized {
    public static void main(String[] args) {

        UnderstandingSynchronized us = new UnderstandingSynchronized();

        Thread t1 = new Thread(() -> us.count());

        Thread t2 = new Thread(() -> us.count());

        Thread t3 = new Thread(() -> System.out.println("Hello "));

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void count()  {
        String lock = "lock";
        System.out.println("Inside Thread " +Thread.currentThread().getName());
        synchronized (lock) {
            System.out.println("Hello World !!!");
        }
    }


}
