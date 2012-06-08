package com.clouway.threads.threadexamples;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SleepThread extends Thread {

  public void run() {
    System.out.println("run()...");
  }

  public static void main(String[] args) {
    Thread myThread = new SleepThread();
    myThread.start(); //call run()

    try {
      for (int i = 1; i < 4; i++) {

        System.out.println("thread is sleeping...");
        myThread.sleep(2000);
        myThread.run();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
