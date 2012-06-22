package com.clouway.threads.tasks.timeouthashtable;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */

public class Main {
  public static void main(String[] args) throws InterruptedException {
    TimeoutHashtable timeoutHashtable = new TimeoutHashtable(10);

    timeoutHashtable.put("John", 20);
    Thread.sleep(2000);
    System.out.println(timeoutHashtable.get("John"));
    Thread.sleep(3000);

//    Thread.sleep(2000);
//    System.out.println(timeoutHashtable.get("John"));

//    System.out.println(timeoutHashtable.remove("John"));
//
    timeoutHashtable.put("Kelly", 25);
    Thread.sleep(2000);
    System.out.println(timeoutHashtable.get("Kelly"));
  }
}
