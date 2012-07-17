package com.clouway.gui.thirdcalculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MultiplierTest {
  private Multiplier multiplier;

  @Before
  public void setUp() {
    multiplier = new Multiplier();
  }

  @Test
  public void multiplyTwoPositiveNumbers() {
    double result = multiplier.calculate(12, 3);
    assertEquals(36.0, result);
  }

  @Test
  public void multiplyPositiveByNegative() {
    double result = multiplier.calculate(12, -3);
    assertEquals(-36.0, result);
  }

  @Test
  public void multiplyTwoNegativeNumbers() {
    double result = multiplier.calculate(-12, -3);
    assertEquals(36.0, result);
  }

  @Test
  public void multiplyByZero() {
    double result = multiplier.calculate(12, 0);
    assertEquals(0.0, result);
  }

  @Test
  public void multiplyTwoZeros() {
    double result = multiplier.calculate(0, 0);
    assertEquals(0.0, result);
  }
}
