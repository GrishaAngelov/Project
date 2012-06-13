package com.clouway.threads.waitandnotifyexample;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    final Processor processor = new Processor();
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {

        try {
          processor.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    });
    t1.start();

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          processor.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    t2.start();
  }
}
