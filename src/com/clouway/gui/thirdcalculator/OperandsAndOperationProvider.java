package com.clouway.gui.thirdcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class OperandsAndOperationProvider {
  private double firstNumber;
  private double secondNumber;
  private String operation;

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

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
