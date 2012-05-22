package com.clouway.testing.store;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LackOfProductException extends RuntimeException{
  public LackOfProductException(){
    super("The product is not available!");
  }
}