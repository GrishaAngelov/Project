package com.clouway.threads.tasks.synchronizedthreadcounter;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {

  public static void main(String[] args) {
    Counter counter = new Counter();

    ThreadCounter mainCounter = new ThreadCounter(counter, 5);
    ThreadCounter threadForTermination = new ThreadCounter(counter, 5);

    Thread thread1 = new Thread(mainCounter, "firstThread");
    Thread thread2 = new Thread(threadForTermination, "secondThread");

    thread1.start();
    thread2.start();
  }
}