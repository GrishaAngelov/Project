package com.clouway.threads.javahowtoprogramthreads.printtask;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ThreadCreator {
  public static void main(String[] args) {
    Thread thread1 = new Thread(new PrintTask("firstThread"));
    Thread thread2 = new Thread(new PrintTask("secondThread"));
    Thread thread3 = new Thread(new PrintTask("thirdThread"));

    System.out.println("The threads are created, starting...");
    thread1.start();
    thread2.start();
    thread3.start();
  }
}
