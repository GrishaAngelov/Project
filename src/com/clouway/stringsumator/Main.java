package com.clouway.stringsumator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    StringSumator stringSumator = new StringSumator();
    try {
      System.out.print("sum: " + stringSumator.sum("5", "2"));
    } catch (NumberFormatException nfe) {
      nfe.printStackTrace();
    }
  }
}
