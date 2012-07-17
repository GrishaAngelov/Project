package com.clouway.gui.thirdcalculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DivisorTest {
  private Divisor divisor;

  @Before
  public void setUp() {
    divisor = new Divisor();
  }

  @Test
  public void dividePositiveNumbers() {
    double result = divisor.calculate(12, 3);
    assertEquals(4.0, result);
  }

  @Test
  public void dividePositiveByNegative() {
    double result = divisor.calculate(12, -3);
    assertEquals(-4.0, result);
  }

  @Test
  public void dividePositiveByZero() {
    float positiveInfinity = divisor.calculate(5.0, 0).floatValue();
    assertEquals(Float.POSITIVE_INFINITY, positiveInfinity);
  }

  @Test
  public void dividePositiveByNegativeZero() {
    float infinity = divisor.calculate(5.0, -0).floatValue();
    assertEquals(Float.POSITIVE_INFINITY, infinity);
  }

  @Test
  public void divideNegativeByZero() {
    float infinity = divisor.calculate(-5.0, 0).floatValue();
    assertEquals(Float.NEGATIVE_INFINITY, infinity);
  }

  @Test
  public void divideNegativeNumberByNegativeZero() {
    float infinity = divisor.calculate(-5.0, -0).floatValue();
    assertEquals(Float.NEGATIVE_INFINITY, infinity);
  }
}
