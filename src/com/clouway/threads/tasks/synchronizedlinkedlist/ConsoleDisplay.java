package com.clouway.threads.tasks.synchronizedlinkedlist;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ConsoleDisplay implements Display {

  @Override
  public void write(String message) {
    System.out.println(message);
  }
}