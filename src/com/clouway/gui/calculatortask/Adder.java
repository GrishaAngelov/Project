package com.clouway.gui.calculatortask;


/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Adder implements Operation {
  public Double calculate(double firstNumber, double secondNumber){
    return  firstNumber + secondNumber;
  }
}
