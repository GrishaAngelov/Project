package com.clouway.threads.threadexamples;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UsingFlagToShutdownThread extends Thread {
  private boolean running = true;

  public void run() {
    while (running) {
      System.out.print("*");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("\nShutting down thread");
  }

  public void shutdown() {
    running = false;
  }

  public static void main(String[] args) throws InterruptedException {
    UsingFlagToShutdownThread thread = new UsingFlagToShutdownThread();
    thread.start();
    thread.sleep(5000);
    thread.shutdown();
  }
}