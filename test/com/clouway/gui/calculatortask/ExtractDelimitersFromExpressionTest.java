package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExtractDelimitersFromExpressionTest {
  private ExpressionServicesProvider servicesProvider;

  @Before
  public void setUp() {
    servicesProvider = new ExpressionServicesProvider();
  }

  @Test
  public void extractDelimitersInExpression() {
    String expression = "2+3-4+6";
    List<String> extractedDelimiters = servicesProvider.extractDelimitersInString(expression);
    List<String> expectedDelimiters = Arrays.asList("+","-","+");
    assertEquals(expectedDelimiters, extractedDelimiters);
  }
}
