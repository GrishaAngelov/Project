package com.clouway.threads.tasks.timeouthashtable;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */

public class Main {
  public static void main(String[] args) {
    TimeoutHashtable timeoutHashtable = new TimeoutHashtable();

    Timer timer1 = new Timer(timeoutHashtable);

    Thread thread1 = new Thread(timer1,"myThread");

    thread1.start();
  }
}
