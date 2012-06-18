package com.clouway.threads.tasks.synchronizedthreadcounter;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ThreadCounter implements Runnable {

  private int maxValue;
  private Counter counter;

  public ThreadCounter(Counter counter, int maxValue) {
    this.counter = counter;
    this.maxValue = maxValue;
  }

  public void run() {
    try {
      Thread.sleep(100);
      counter.count(maxValue);
    } catch (InterruptedException e) {
    }
  }
}
