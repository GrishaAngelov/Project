package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class OperandsProvider {
  private double firstNumber;
  private double secondNumber;

  public double getFirstNumber() {
    return firstNumber;
  }

  public double getSecondNumber() {
    return secondNumber;
  }

  public void setFirstNumber(double firstNumber) {
    this.firstNumber = firstNumber;
  }

  public void setSecondNumber(double secondNumber) {
    this.secondNumber = secondNumber;
  }
}
