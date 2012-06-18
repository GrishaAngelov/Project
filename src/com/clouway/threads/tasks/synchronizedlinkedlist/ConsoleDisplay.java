package com.clouway.threads.tasks.synchronizedlinkedlist;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ConsoleDisplay implements Display {

  @Override
  public void write(String message) {
    System.out.println(message);
  }
}