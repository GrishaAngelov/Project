package com.clouway.gui.thirdcalculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SubtractorTest {
  private Subtractor subtractor;

  @Before
  public void setUp() {
    subtractor = new Subtractor();
  }

  @Test
  public void subtractTwoPositiveNumbers() {
    double result = subtractor.calculate(12, 3);
    assertEquals(9.0, result);
  }

  @Test
  public void subtractBiggerPositiveFromSmallerNegative() {
    double result = subtractor.calculate(12, -3);
    assertEquals(15.0, result);
  }

  @Test
  public void subtractSmallerPositiveFromBiggerNegative() {
    double result = subtractor.calculate(3, -12);
    assertEquals(15.0, result);
  }

  @Test
  public void subtractTwoNegativeNumbers() {
    double result = subtractor.calculate(-12, -3);
    assertEquals(-9.0, result);
  }

  @Test
  public void subtractFromZero() {
    double result = subtractor.calculate(12, 0);
    assertEquals(12.0, result);
  }

  @Test
  public void subtractTwoZeros() {
    double result = subtractor.calculate(0, 0);
    assertEquals(0.0, result);
  }
}
