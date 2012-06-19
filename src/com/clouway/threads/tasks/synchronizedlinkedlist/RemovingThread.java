package com.clouway.threads.tasks.synchronizedlinkedlist;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RemovingThread implements Runnable {
  private LinkedList list;

  public RemovingThread(LinkedList list) {
    this.list = list;
  }

  public synchronized void run() {
    try {
      Thread.sleep(200);
      list.remove();
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
