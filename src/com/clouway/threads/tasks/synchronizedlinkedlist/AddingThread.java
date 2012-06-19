package com.clouway.threads.tasks.synchronizedlinkedlist;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AddingThread implements Runnable {

  private LinkedList list;
  private Object object;
  private ConsoleDisplay consoleDisplay;

  public AddingThread(LinkedList list, ConsoleDisplay consoleDisplay, Object object) {
    this.list = list;
    this.object = object;
    this.consoleDisplay = consoleDisplay;
  }

  public synchronized void run() {
    try {
      list.add(object);
      System.out.println("printing all elements");
      list.printAllElements(consoleDisplay);
      Thread.sleep(200);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}