package com.clouway.exceptions.LinkedList;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EmptyListRemoveException extends RuntimeException {
  public EmptyListRemoveException() {
    super("You are trying to remove node from empty linked list!");
  }
}