package io.practise.myPractice;

public class NewThread extends Thread {

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(new NewThread());
        Thread b = new Thread(new NewThread());
        Thread c = new Thread(new NewThread());
        a.setName("First");
        b.setName("Second");
        c.setName("Third");
        a.start();
        b.start();
        c.start();
        c.join();
    }

    public void run() {
        int i = 0;
        while (i < 10) {
            System.out.println(i + " " + Thread.currentThread().getName());
            if (i == 2 && Thread.currentThread().getName().equals("First")) {
                System.out.println(Thread.currentThread().getName() + " is changing its priority");
                Thread.currentThread().yield();
            }
            i++;
        }
    }
}