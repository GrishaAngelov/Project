package com.clouway.gui.secondcalculator;

import java.util.List;
import java.util.Map;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MathCalculatorImpl implements MathCalculator {
  private Map<String, Evaluator> evaluatorMap;

  public MathCalculatorImpl(Map<String, Evaluator> evaluatorMap) {
    this.evaluatorMap = evaluatorMap;
  }

  @Override
  public boolean isCalculationOperation(String operationName) {
    return false;
  }



  @Override
  public int calculate(List<String> operationStack) {
    int number1 = Integer.valueOf(operationStack.get(0));
    String operation = operationStack.get(1);
    int number2 = Integer.valueOf(operationStack.get(2));


    Evaluator evaluator = evaluatorMap.get(operation);

    return evaluator.evaluate(number1, number2);
  }
}
