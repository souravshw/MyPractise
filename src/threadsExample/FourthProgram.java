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
 *
 * @author Sanu
 * Here we were trying to implement 
 * synchronized keyword in each of the method that is common for both of the thread.
 * Therefore the common resource need to have synchronized keyword, 
 * as they can give funny exceptions when accessed by multiple thread.
 * The join keyword makes the parent thread wait for the child thread.
 * As join itself calls notify method so that the parent thread will be informed
 * if child thread is completed.
 * 
 */
public class FourthProgram {

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
        FourthProgram fp = new FourthProgram();
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
