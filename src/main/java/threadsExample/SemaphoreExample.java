/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsExample;

import java.util.concurrent.Semaphore;

/**
 *
 * @author sanu
 */
public class SemaphoreExample {
    
    static Semaphore semaphore = new Semaphore(2);
    
    static class MyAtmThread extends Thread{
        
    }

    public static void main(String[] args) {
        
    }
}

//class Semaphore extends Thread {
//    
//}
