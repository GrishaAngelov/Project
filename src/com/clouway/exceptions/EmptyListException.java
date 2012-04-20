package com.clouway.exceptions;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EmptyListException extends Exception {
  public EmptyListException() {
    super("List is empty!");
  }
}