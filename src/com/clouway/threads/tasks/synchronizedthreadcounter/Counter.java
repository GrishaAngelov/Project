package com.clouway.threads.tasks.synchronizedthreadcounter;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Counter {

  public synchronized void count(int maxValue) throws InterruptedException {
    int counter = 0;
    while (counter < maxValue) {
      Thread.sleep(1000);
      counter++;
      System.out.println(Thread.currentThread().getName() + " - " + counter);
      notify();

      if (counter == maxValue) {
        Thread.currentThread().interrupt();
      }

      wait();
    }
  }
}