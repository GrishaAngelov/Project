package com.clouway.numberreader;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class NumberInputOutOfRange extends RuntimeException{
  public NumberInputOutOfRange() {
    super("You are trying to enter a number that is out of range [0,100] !");
  }
}
