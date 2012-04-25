package com.clouway.exceptions.stringsumator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class StringSumator {
  public String sum(String firstNum, String secondNum) {
    Double sum = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
    return sum.toString();
  }
}
