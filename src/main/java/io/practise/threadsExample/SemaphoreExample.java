/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.practise.threadsExample;

import java.util.concurrent.Semaphore;

/**
 * @author sanu
 */
public class SemaphoreExample {

    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

    }

    static class MyAtmThread extends Thread {

    }
}

//class Semaphore extends Thread {
//    
//}
