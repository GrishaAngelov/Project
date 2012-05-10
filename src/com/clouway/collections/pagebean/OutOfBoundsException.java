package com.clouway.collections.pagebean;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class OutOfBoundsException extends RuntimeException{
  public  OutOfBoundsException(){
    super("You are trying to get out of the bounds!");
  }
}
