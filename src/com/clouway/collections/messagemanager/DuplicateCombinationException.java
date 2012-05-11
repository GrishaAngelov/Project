package com.clouway.collections.messagemanager;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DuplicateCombinationException extends RuntimeException{
  public DuplicateCombinationException(){
    super("Duplicate combination (messageCode,message) !");
  }
}
