package com.clouway.testing.sumator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SumatorTest {

  private Sumator sumator;

  @Before
  public void createSumator() {
    sumator = new Sumator();
  }

  @Test
  public void testSum() {
    assertEquals("8.0", sumator.sum("5", "3"));
  }

  @Test(expected = NumberFormatException.class)
  public void testSumWithIncorrectValue() {
    assertEquals("8.0", sumator.sum("asd", "3"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSumWithNullArgument(){
    assertEquals("8.0", sumator.sum(null, "3"));
  }
}
