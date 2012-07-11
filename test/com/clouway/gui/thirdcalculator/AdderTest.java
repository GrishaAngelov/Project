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
  public void add() {
    double result = adder.calculate(12, 3);
    assertEquals(15.0, result);
  }
}
