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
  public void testSumOfIntegerNumbers() {
    assertEquals("8.0", sumator.sum("5", "3"));
  }

  @Test
  public void testSumOfDoubleNumbers() {
    assertEquals("10.0", sumator.sum("7.3", "2.7"));
  }

  @Test
  public void testSumOfZeros() {
    assertEquals("0.0", sumator.sum("0", "0"));
  }

  @Test(expected = NumberFormatException.class)
  public void testSumWithIncorrectValue() {
    sumator.sum("asd", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSumWithNullArgument(){
    sumator.sum(null, "3");
  }
}
