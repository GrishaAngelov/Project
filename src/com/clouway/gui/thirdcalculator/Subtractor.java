package com.clouway.gui.thirdcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Subtractor implements Operation{
  public Double calculate(double firstNumber, double secondNumber){
    return  firstNumber - secondNumber;
  }
}
