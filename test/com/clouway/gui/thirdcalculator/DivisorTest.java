package com.clouway.gui.thirdcalculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
  public void divide() {
    double result = divisor.calculate(12, 3);
    assertEquals(4.0, result);
  }
}
