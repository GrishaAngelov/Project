package com.clouway.threads.tasks.timeouthashtable;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */

public class Main {
  public static void main(String[] args) throws InterruptedException {
    TimeoutHashtable timeoutHashtable = new TimeoutHashtable(10);

    timeoutHashtable.put("John",20);
    Thread.sleep(2000);
    timeoutHashtable.put("Kelly", 19);
//    Thread.sleep(1000);
//    System.out.println(timeoutHashtable.get("John"));
  }
}
