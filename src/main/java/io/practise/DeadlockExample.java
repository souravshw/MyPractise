package io.practise;

public class DeadlockExample implements Runnable{


    public synchronized int f1() {
        f2();
        return 0;
    }

    public synchronized int f2() {
        f1();
        return 0;
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> new DeadlockExample());

        t1.start();
    }

    @Override
    public void run() {
        f1();
    }
}
