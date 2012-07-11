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
  public void subtract() {
    double result = subtractor.calculate(12, 3);
    assertEquals(9.0, result);
  }
}
