package io.practise.threadsExample;

import java.util.concurrent.Semaphore;

/**
 * @author sanu
 */
public class SemaphoreExample {

  // Only 2 people can use the ATM booth at the same time
  static Semaphore semaphore = new Semaphore(2);

  public static void main(String[] args) {
      new MyAtmThread("Alice").start();
      new MyAtmThread("Bob").start();
      new MyAtmThread("Charlie").start();
  }

  static class MyAtmThread extends Thread {
      public MyAtmThread(String name) {
          super(name);
      }

      @Override
      public void run() {
          try {
              System.out.println(getName() + " is waiting to enter the ATM booth...");
              semaphore.acquire();
              System.out.println(getName() + " entered the booth and is doing transactions.");
              Thread.sleep(2000); // Simulate transaction time
              System.out.println(getName() + " is leaving the ATM booth.");
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              semaphore.release();
          }
      }
  }
}
