package com.clouway.threads.priorityThread;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    Thread thread1 = new Thread(new ThreadWriter(),"firstThread");
    Thread thread2 = new Thread(new ThreadWriter(),"secondThread");

    thread1.setPriority(10);
    thread2.setPriority(3);

    thread1.start();
    thread2.start();
  }
}
