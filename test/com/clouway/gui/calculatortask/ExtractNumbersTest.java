package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    List<String> extractedNumbers = evaluator.extractNumbersAsStringsFrom(expression);
    List<String> expectedNumberArray = Arrays.asList("2", "6", "3");
    assertEquals(expectedNumberArray, extractedNumbers);
  }

}
