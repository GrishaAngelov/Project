package com.clouway.collections.messagemanager;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class KeyNotFoundException extends RuntimeException{
  public KeyNotFoundException(){
    super("Key not found !");
  }
}
