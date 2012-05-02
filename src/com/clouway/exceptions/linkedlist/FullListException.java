package com.clouway.exceptions.linkedlist;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class FullListException extends RuntimeException {
  public FullListException() {
    super("You are trying to add a new node on an already full linked list!");
  }
}