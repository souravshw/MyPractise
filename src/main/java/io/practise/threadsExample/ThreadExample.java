/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.practise.threadsExample;

/**
 * @author sanu
 */
public class ThreadExample {

    public ThreadExample() {
        new SimpleThread("Thread 1").start();

        new SimpleThread("Thread 2").start();

        new SimpleThread("Thread 3").start();

        new SimpleThread("Thread 4").start();

        new SimpleThread("Thread 5").start();

        Thread thread = new Thread(new SecondSimpleThread());

        thread.start();
    }

    public static void main(String args[]) {
        ThreadExample te = new ThreadExample();

    }

}

class SimpleThread extends Thread {

    public SimpleThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }
}

class SecondSimpleThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getClass().getName() + " " + i);

        }
    }
}
