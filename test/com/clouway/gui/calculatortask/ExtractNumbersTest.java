package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExtractNumbersTest {
  private ExpressionEvaluator evaluator;

  @Before
  public void setUp() {
    evaluator = new ExpressionEvaluator();
  }

  @Test
  public void extractNumbers() {
    String expression = "2+6-3";
    String[] extractedNumbers = evaluator.extractNumbersAsStringsFrom(expression);
    String[] expectedNumberArray = {"2", "6", "3"};
    assertArrayEquals(expectedNumberArray, extractedNumbers);
  }

}
