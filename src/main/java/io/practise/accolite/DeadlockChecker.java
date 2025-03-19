package io.practise.accolite;

import java.util.concurrent.locks.*;

import static java.lang.Thread.sleep;

public class DeadlockChecker {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        DeadlockChecker deadlock = new DeadlockChecker();

        try {
            new Thread(deadlock::operation1, "T1").start();
            new Thread(deadlock::operation2, "T2").start();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void operation1() {
        lock1.lock();
        print("lock1 acquired, waiting to acquire lock2.");
        try {
            sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        print("lock2 acquired");

        print("executing first operation.");

        lock2.unlock();
        lock1.unlock();
    }

    private void print(String s) {
        System.out.println(s);
    }

    public void operation2() {
        lock2.lock();

        print("lock2 acquired, waiting to acquire lock1.");

        try {
            sleep(50);
            //wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock1.lock();
        print("lock1 acquired");

        print("executing second operation.");

        lock1.unlock();
        lock2.unlock();
    }

}

