package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalculationOperandsProvider {
  private double firstOperand;
  private double secondOperand;

  public double getFirstOperand() {
    return firstOperand;
  }

  public double getSecondOperand() {
    return secondOperand;
  }

  public void setFirstOperand(double firstOperand) {
    this.firstOperand = firstOperand;
  }

  public void setSecondOperand(double secondOperand) {
    this.secondOperand = secondOperand;
  }
}
