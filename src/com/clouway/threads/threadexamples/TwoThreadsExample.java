package com.clouway.threads.threadexamples;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TwoThreadsExample implements Runnable {

  public void run() {
      System.out.println("this is run()... " + Thread.currentThread().getName());
  }

  public static void main(String[] args) throws InterruptedException{
    Thread thread1 = new Thread(new TwoThreadsExample(), "firstThread ");
    Thread thread2 = new Thread(new TwoThreadsExample(), "secondThread ");

    System.out.println(thread1.getName() + "call start()");
    thread1.start();
    thread1.sleep(100);
    System.out.println(thread2.getName() + "call start()");
    thread2.start();
  }
}
