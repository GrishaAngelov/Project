package com.clouway.threads.tasks.counter;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Counter implements Runnable {
  private int counter = 0;
  private int maxValue;

  public Counter(int maxValue) {
    this.maxValue = maxValue;
  }

  public void run() {
    try {
      while (true) {
        counter++;
        System.out.println(Thread.currentThread().getName() + ":" + counter);
        Thread.currentThread().sleep(500);
        if (counter == maxValue) {
          throw new InterruptedException();
        }
      }
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + " stop counter at " + counter);
    }
  }
}
