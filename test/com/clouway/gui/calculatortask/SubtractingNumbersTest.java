package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SubtractingNumbersTest {
  private ExpressionEvaluator evaluator;

  @Before
  public void setUp() {
    evaluator = new ExpressionEvaluator();
  }

  @Test
  public void subtractTwoPositiveNumbers() {
    String expression = "12-3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(9.0, result);
  }

  @Test
  public void subtractSmallerPositiveFromBiggerNegative() {
    String expression = "3-12";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(-9.0, result);
  }

  @Test
  public void subtractTwoNegativeNumbers() {
    String expression = "-12-3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(-15.0, result);
  }

  @Test
  public void subtractFromZero() {
    String expression = "12-0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(12.0, result);
  }

  @Test
  public void subtractTwoZeros() {
    String expression = "0-0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(0.0, result);
  }

  @Test
  public void subtractSame() {
    String expression = "12-12";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(0.0, result);
  }

  @Test
  public void subtractDoubleNumbers() {
    String expression = "12.5-4.2";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(8.3, result);
  }
}
