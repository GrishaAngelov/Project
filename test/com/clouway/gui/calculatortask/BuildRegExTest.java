package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BuildRegExTest {
  private ExpressionServicesProvider servicesProvider;

  @Before
  public void setUp() {
    servicesProvider = new ExpressionServicesProvider();
  }

  @Test
  public void buildRegEx() {
    List<String> operators = new ArrayList<String>();
    operators.add("+");
    operators.add("-");
    operators.add("-");
    String regEx = servicesProvider.buildRegExFrom(operators);
    assertEquals("[+--]", regEx);
  }
}
