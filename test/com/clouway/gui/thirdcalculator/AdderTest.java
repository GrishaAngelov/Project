package com.clouway.gui.thirdcalculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AdderTest {
  private Adder adder;

  @Before
  public void setUp() {
    adder = new Adder();
  }

  @Test
  public void addPositiveNumbers() {
    double result = adder.calculate(12, 3);
    assertEquals(15.0, result);
  }

  @Test
  public void addBiggerPositiveToSmallerNegative() {
    double result = adder.calculate(12, -3);
    assertEquals(9.0, result);
  }

  @Test
  public void addSmallerPositiveToBiggerNegative() {
    double result = adder.calculate(3, -12);
    assertEquals(-9.0, result);
  }

  @Test
  public void addTwoNegativeNumbers() {
    double result = adder.calculate(-12, -3);
    assertEquals(-15.0, result);
  }

  @Test
  public void addToZero() {
    double result = adder.calculate(12, 0);
    assertEquals(12.0, result);
  }

  @Test
  public void addSamePositiveNumbers() {
    double result = adder.calculate(12, 12);
    assertEquals(24.0, result);
  }

  @Test
  public void addSameNegativeNumbers() {
    double result = adder.calculate(-12, -12);
    assertEquals(-24.0, result);
  }

}
