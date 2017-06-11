/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author sanu
 * Using Synchronized blocks and multiple locks.
 * Here we will be using the lock variables in order to lock the semaphore variable.
 */
public class FourthProgramPartTwo {
    
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private Random random = new Random();

    private List<Integer> in1 = new ArrayList<Integer>();
    private List<Integer> in2 = new ArrayList<Integer>();

    public synchronized void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(FourthProgram.class.getName()).log(Level.SEVERE, null, ex);
        }

        in1.add(random.nextInt(10000));
    }

    public synchronized void stageTwo() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(FourthProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
        in2.add(random.nextInt(10000));
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String... args) {
        System.out.println("Starting .........");
        FourthProgramPartTwo fp = new FourthProgramPartTwo();
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                fp.process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                fp.process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(FourthProgram.class.getName()).log(Level.SEVERE, null, ex);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time Consumed: " + (endTime - startTime));

        System.out.println("List 1: " + fp.in1.size() + " List 2: " + fp.in2.size());
    }
    
}
