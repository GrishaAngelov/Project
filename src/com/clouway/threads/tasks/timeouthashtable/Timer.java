package com.clouway.threads.tasks.timeouthashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Timer implements Runnable {
  private int counter = 0;
  private int maxCounterValue = 20;
  private int actionValue = 15;
  private TimeoutHashtable timeoutHashtable;

  public Timer(TimeoutHashtable timeoutHashtable) {
    this.timeoutHashtable = timeoutHashtable;
  }

  public synchronized void run() {
    while (counter < maxCounterValue) {
      counter++;
      System.out.println(Thread.currentThread().getName() + ": " + counter);

      //        timeoutHashtable.put("Peter", 18);
//      System.out.println("get value:" + timeoutHashtable.get("Peter"));
//      System.out.println("get value:" + timeoutHashtable.get("asd"));

      if (counter > actionValue && !timeoutHashtable.getIsUsedValue()) {   // if time runs out and put() and get() were not used, remove
         timeoutHashtable.remove("Peter");
        return;
      }


    }
  }
}