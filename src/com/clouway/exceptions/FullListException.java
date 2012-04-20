package com.clouway.exceptions;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class FullListException extends Exception {
  public FullListException() {
    super("List is full!");
  }
}