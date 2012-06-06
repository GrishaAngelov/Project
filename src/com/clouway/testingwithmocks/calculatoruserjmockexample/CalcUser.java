package com.clouway.testingwithmocks.calculatoruserjmockexample;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalcUser {
  private Calculator calculator;

  public CalcUser(Calculator calculator){
    this.calculator = calculator;
  }

  public double addNumbers(double firstNum, double secondNum){
   return calculator.add(firstNum,secondNum);
  }

  public double subtractNumbers(double firstNum,double secondNum){
    return calculator.sub(firstNum,secondNum);
  }

}
