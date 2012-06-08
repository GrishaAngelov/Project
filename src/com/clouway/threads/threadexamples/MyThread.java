package com.clouway.threads.threadexamples;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyThread {
  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("this is run()...");
      }
    });

    thread.start();
  }
}
