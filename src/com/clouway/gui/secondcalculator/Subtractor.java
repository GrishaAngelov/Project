package com.clouway.gui.secondcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Subtractor implements Operation {

  public Double calculate(double firstNum, double secondNum) {
    return firstNum - secondNum;
  }
}
