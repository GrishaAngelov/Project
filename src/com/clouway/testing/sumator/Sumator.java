package com.clouway.testing.sumator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Sumator {
  /**
   * Calculates sum of two numbers, type String
   *
   * @param firstNumber
   * @param secondNumber
   * @return sum of String numbers
   */
  public String sum(String firstNumber, String secondNumber) {
    if(firstNumber == null || secondNumber== null){
      throw new IllegalArgumentException();
    }
    Double sum = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
    return sum.toString();
  }
}
