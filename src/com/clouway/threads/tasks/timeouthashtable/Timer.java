package com.clouway.threads.tasks.timeouthashtable;

import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Timer implements Runnable {
  private Hashtable<String, Object> table;
  private int time;
  private Integer counter = 0;
  private boolean stop = false;
  private String key;
  private Checker checker;

  public Timer(int time, Hashtable table, String key, Checker checker) {
    this.time = time;
    this.table = table;
    this.key = key;
    this.checker = checker;
    checker.setUsed(false);
    new Thread(this).start();
  }

  public void run() {
    while (!stop) {
      if (counter < time) {
        if (!checker.getIsUsed()) {
          counter++;
          System.out.println(Thread.currentThread().getName() + "'s Counter: " + counter);
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } else {
          counter = 1;
          System.out.println(Thread.currentThread().getName() + "'s Counter: " + counter);
          checker.setUsed(false);
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      } else {
        table.remove(key);
        System.out.printf("time runs out... %s pair is removed\n", Thread.currentThread().getName());
        stop = true;
      }
    }
  }
}