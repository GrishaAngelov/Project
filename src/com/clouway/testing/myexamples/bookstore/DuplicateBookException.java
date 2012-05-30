package com.clouway.testing.myexamples.bookstore;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DuplicateBookException extends RuntimeException {
  public DuplicateBookException() {
    super("A book with this ISBN has already been added!");
  }
}