package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DividingNumbersTest {

  private ExpressionEvaluator evaluator;

  @Before
  public void setUp() {
    evaluator = new ExpressionEvaluator();
  }


  @Test
  public void divideDifferentNumbers() {
    String expression = "12/3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(4.0, result, 0);
  }

  @Test
  public void divideBiggerNegativeToSmallerPositive() {
    String expression = "-12/3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(-4.0, result, 0);
  }

  @Test
  public void divideSameNumbers() {
    String expression = "12/12";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(1.0, result);
  }

  @Test(expected = DivideByZeroException.class)
  public void divideNumberByZero() {
    String expression = "12.3/0";
    evaluator.evaluateExpression(expression);
  }


  @Test
  public void divideDoubleNumbers() {
    String expression = "4.8/2.0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(2.4, result);
  }
}
