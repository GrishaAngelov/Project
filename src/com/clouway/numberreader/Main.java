package com.clouway.numberreader;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    System.out.print("Enter number [0-100]: ");
    NumberReader numberReader = new NumberReader();
    try {
      System.out.print("Your number: "+numberReader.readNumber());
    } catch (NumberFormatException nfe) {
      nfe.printStackTrace();
    }
  }
}
