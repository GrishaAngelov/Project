package com.clouway.threads.javahowtoprogramthreads.printtask;

import java.util.Random;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PrintTask implements Runnable {
  private int timeSleep = 0;
  private String taskName;
  private Random random = new Random();

  public PrintTask(String taskName) {
    this.taskName = taskName;
    timeSleep = random.nextInt(5000);
  }

  public void run() {
    System.out.printf("Task \"%s\" is going to sleep for %d ms\n", taskName, timeSleep);
    try {
      Thread.sleep(timeSleep);
//      Thread.currentThread().sleep(timeSleep);
    } catch (InterruptedException e) {
      System.out.printf("Task \"%s\" is interrupted\n", taskName);
    }
    System.out.printf("Task \"%s\" is done sleeping\n", taskName);
  }
}
