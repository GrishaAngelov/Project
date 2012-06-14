package com.clouway.threads.priorityThread;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ThreadWriter implements Runnable {

  public void run() {
    System.out.println("thread name: " + Thread.currentThread().getName());
    System.out.println(Thread.currentThread().getName()+" priority: " + Thread.currentThread().getPriority());

    for (int i = 0; i < 5; i++) {
      System.out.printf("thread %s is writing....\n", Thread.currentThread().getName());
    }
    System.out.println(Thread.currentThread().getName() + " - " + System.currentTimeMillis());

  }
}
