package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalculateExpressionTest {
  private ExpressionEvaluator evaluator;

  @Before
  public void setUp() {
    evaluator = new ExpressionEvaluator();
  }

  @Test
  public void calculateSubtractAndAddExpression() {
    String expression = "2+6-3+5-1+4";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(13.0, result);
  }

  @Test
  public void calculateMultiplyAndDivideExpression() {
    String expression = "2*6/3";
    double result = evaluator.evaluateExpression(expression);
    assertEquals(4.0, result);
  }

}
