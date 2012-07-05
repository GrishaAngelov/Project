package com.clouway.gui.secondcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Divisor implements Operation {

  public Double calculate(double firstNum, double secondNum) {
    return firstNum / secondNum;
  }
}