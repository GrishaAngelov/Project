package com.clouway.threads.threadexamples;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyThreadImplementsRunnable implements Runnable {
  public void run() {
    System.out.println("this is run()...");
  }

  public static void main(String[] args) {
    Thread myThread = new Thread(new MyThreadImplementsRunnable());
    myThread.start();
  }
}
