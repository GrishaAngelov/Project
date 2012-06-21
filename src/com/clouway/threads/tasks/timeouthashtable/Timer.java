package com.clouway.threads.tasks.timeouthashtable;

import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Timer implements Runnable {
  private Hashtable<String, Object> table;
  private int time;
  private int counter = 0;
  private boolean stop = false;
  private String key;

  public Timer(int time, Hashtable table, String key) {
    this.time = time;
    this.table = table;
    this.key = key;
    new Thread(this).start();
  }

  public void run() {
    while (!stop) {
      if (counter < time) {
        if(Thread.currentThread().isInterrupted()){
          time++;
        }
        counter++;
        System.out.println(Thread.currentThread().getName()+"'s Counter: " + counter);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else {
        table.remove(key);
        System.out.printf("time runs out... %s pair is removed\n",Thread.currentThread().getName());
        stop = true;
      }
    }
  }
}