package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MultiplyingNumbersTest {
  private ExpressionEvaluator evaluator;

  @Before
  public void setUp() {
    evaluator = new ExpressionEvaluator();
  }

  @Test
  public void multiplyTwoPositiveNumbers() {
    String expression = "12*3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(36.0, result);
  }

//  @Test
//  public void multiplyPositiveByNegative() {
//    String expression = "12*(-3)";
//    double result = evaluator.evaluateExpression(expression);
//    assertEquals(-36.0, result);
//  }


  @Test
  public void multiplyNegativeByPositive() {
    String expression = "-12*3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(-36.0, result);
  }

  @Test
  public void multiplyByZero() {
    String expression = "12*0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(0.0, result);
  }

  @Test
  public void multiplyTwoZeros() {
    String expression = "0*0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(0.0, result);
  }
}
