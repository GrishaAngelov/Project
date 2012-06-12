package com.clouway.threads.tasks.threadcounter;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {


  public static void main(String[] args) {
    ThreadCounter mainCounter = new ThreadCounter(5);
    ThreadCounter threadForTermination = new ThreadCounter(10);

    Thread thread1 = new Thread(mainCounter, "firstThread");
    Thread thread2 = new Thread(threadForTermination, "secondThread");

    threadForTermination.setThreadForTermination(mainCounter);
    mainCounter.setThreadForTermination(threadForTermination);

    thread1.start();
    thread2.start();
  }
}
