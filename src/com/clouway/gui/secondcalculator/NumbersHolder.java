package com.clouway.gui.secondcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class NumbersHolder {
  private double firstNum;
  private double secondNum;
  private String operation;

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public double getFirstNum() {
    return firstNum;
  }

  public double getSecondNum() {
    return secondNum;
  }

  public void setFirstNum(double firstNum) {
    this.firstNum = firstNum;
  }

  public void setSecondNum(double secondNum) {
    this.secondNum = secondNum;
  }
}
