package com.clouway.gui.thirdcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Adder implements Operation{
  public double calculate(double firstNumber, double secondNumber){
    return  firstNumber + secondNumber;
  }
}
