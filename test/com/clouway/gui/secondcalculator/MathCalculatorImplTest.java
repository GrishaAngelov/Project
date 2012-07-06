package com.clouway.gui.secondcalculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MathCalculatorImplTest {

  class PlusEvaluator implements Evaluator {

    @Override
    public int evaluate(int a, int b) {
      return a + b;
    }

  }

  class MinusEvaluator implements Evaluator {

    @Override
    public int evaluate(int a, int b) {
      return a - b;
    }
  }

  @Test
  public void plusIsAddingTwoNumbers() throws Exception {
    List<String> operationStack = new ArrayList<String>();
    operationStack.add("9");
    operationStack.add("+");
    operationStack.add("3");

    MathCalculatorImpl calculator = createMathCalculator();
    int result = calculator.calculate(operationStack);

    assertThat(result,is(equalTo(12)));
  }


  @Test
  public void minusIsSubstractingTwoNumbers() throws Exception {
    List<String> operationStack = new ArrayList<String>();
    operationStack.add("9");
    operationStack.add("-");
    operationStack.add("3");

    MathCalculatorImpl calculator = createMathCalculator();
    int result = calculator.calculate(operationStack);

    assertThat(result,is(equalTo(6)));
  }

  @Test
  public void divisionIsDividingTwoNumbers() throws Exception {
    List<String> operationStack = new ArrayList<String>();
    operationStack.add("8");
    operationStack.add("/");
    operationStack.add("2");

    MathCalculatorImpl calculator = createMathCalculator();
    int result = calculator.calculate(operationStack);

    assertThat(result,is(equalTo(4)));
  }


  private MathCalculatorImpl createMathCalculator() {
    Map<String, Evaluator> evaluatorMap = new HashMap<String, Evaluator>();
    evaluatorMap.put("+", new PlusEvaluator());
    evaluatorMap.put("-", new MinusEvaluator());
    return new MathCalculatorImpl(evaluatorMap);
  }
}
