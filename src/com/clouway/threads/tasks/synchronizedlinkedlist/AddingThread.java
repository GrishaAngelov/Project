package com.clouway.threads.tasks.synchronizedlinkedlist;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AddingThread implements Runnable {

  private LinkedList list;
  private int value;
  private ConsoleDisplay consoleDisplay;

  public AddingThread(LinkedList list, ConsoleDisplay consoleDisplay, int value) {
    this.list = list;
    this.value = value;
    this.consoleDisplay = consoleDisplay;
  }

  public synchronized void run() {
    try {
      list.add(value);
      System.out.println("printing all elements");
      list.printAllElements(consoleDisplay);
      Thread.sleep(200);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}