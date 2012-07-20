package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AddingNumbersTest {

  private ExpressionEvaluator evaluator;

  @Before
  public void setUp() {
    evaluator = new ExpressionEvaluator();
  }


  @Test
  public void addDifferentNumbers() {
    String expression = "12+3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(15.0, result, 0);
  }

  @Test
  public void addBiggerNegativeToSmallerPositive() {
    String expression = "-12+3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(-9.0, result, 0);
  }

  @Test
  public void addSameNumbers() {
    String expression = "12+12";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(24.0, result);
  }

  @Test
  public void addNumberToZero() {
    String expression = "12+0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(12.0, result);
  }

  @Test
  public void addZeroNumbers() {
    String expression = "0+0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(0.0, result);
  }

  @Test
  public void addNegativeToZero() {
    String expression = "-12+0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(-12.0, result);
  }

  @Test
  public void addNegativeZeroToZero() {
    String expression = "-0+0";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(0.0, result);
  }

}
