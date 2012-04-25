package com.clouway.exceptions.stringsumator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    StringSumator stringSumator = new StringSumator();
    try {
      System.out.print("sum: " + stringSumator.sum("5a", "2"));
    } catch (NumberFormatException nfe) {
      System.out.print("Incorrect input!");
    }
  }
}
