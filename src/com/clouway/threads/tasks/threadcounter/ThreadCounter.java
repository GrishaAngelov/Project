package com.clouway.threads.tasks.threadcounter;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ThreadCounter implements Runnable {
  private int counter = 0;
  private int maxValue;
  private boolean stop = false;
  private ThreadCounter otherThread;

  public ThreadCounter(int maxValue) {
    this.maxValue = maxValue;
  }

  public void setThreadForTermination(ThreadCounter otherThread) {
    this.otherThread = otherThread;
  }

  public void run() {
    do {
      try {
        counter++;
        System.out.println(Thread.currentThread().getName() + ":" + counter);
        Thread.sleep(500);
        if (counter == maxValue) {
          stop = true;
          otherThread.tryToStop();
        }
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName() + " stop counter at " + counter);
      }
    } while (!stop);
  }

  private void tryToStop() {
    stop = true;
  }
}
