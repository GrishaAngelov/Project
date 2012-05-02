package com.clouway.exceptions.linkedlist;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EmptyListException extends RuntimeException {
  public EmptyListException() {
    super("You are trying to remove node from empty linked list!");
  }
}