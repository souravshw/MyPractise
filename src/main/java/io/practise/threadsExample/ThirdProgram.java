/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.practise.threadsExample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sanu
 * Every object in  has intrinsic lock, or mutex. As we are implementing synchronized then the thread
 * will have to wait to acquire the lock for the common resource.
 */
public class ThirdProgram {

    int count = 0;

    public static void main(String[] args) {
        ThirdProgram tp = new ThirdProgram();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    tp.doWork();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    tp.doWork();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThirdProgram.class.getName()).log(Level.SEVERE, null, ex);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time Consumption: " + (endTime - startTime));
        System.out.println("Count: " + tp.count);
    }

    public synchronized void doWork() {
        count++;
    }
}