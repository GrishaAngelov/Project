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
  public void multiply() {
    double result = multiplier.calculate(12, 3);
    assertEquals(36.0, result);
  }
}
