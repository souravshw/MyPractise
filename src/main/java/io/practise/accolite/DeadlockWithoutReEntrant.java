package io.practise.accolite;

public class DeadlockWithoutReEntrant {
    private Object lock = new Object();
    private Object lock2 = new Object();

    public static void main(String[] args) {
        DeadlockWithoutReEntrant deadlockWithoutReEntrant = new DeadlockWithoutReEntrant();

        new Thread(() -> {
            try {
                deadlockWithoutReEntrant.test1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                deadlockWithoutReEntrant.test2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void test1() throws InterruptedException {
        synchronized (lock) {
            synchronized (lock2) {
                Thread.sleep(5000);
            }
        }
    }

    public void test2() throws InterruptedException {
        synchronized (lock2) {
            synchronized (lock) {
                Thread.sleep(5000);
            }
        }
    }
}
