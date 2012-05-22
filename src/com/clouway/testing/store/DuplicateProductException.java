package com.clouway.testing.store;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DuplicateProductException extends RuntimeException{
    public DuplicateProductException(){
      super("Your product has already been added!");
    }
}
