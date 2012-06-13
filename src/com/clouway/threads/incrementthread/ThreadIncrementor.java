package com.clouway.threads.incrementthread;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ThreadIncrementor {
  private int counter = 0;

  public synchronized void incermet(){
    counter++;
  }

  public void action() {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100000; i++) {
          incermet();
        }
      }
    });
    t1.start();

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 100000; i++) {
          incermet();
        }
      }
    });
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Counter: " + counter);
  }
}
