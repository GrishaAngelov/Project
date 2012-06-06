package com.clouway.testingwithmocks.calculatoruserjmockexample;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
@RunWith(JMock.class)
public class CalcUserTest {
  private Mockery context = new JUnit4Mockery();
  private Calculator calculator = context.mock(Calculator.class);
  private CalcUser calcUser;

  @Before
  public void setUp() {
    calcUser = new CalcUser(calculator);
  }

  @Test
  public void testAdd() {
    context.checking(new Expectations() {{
      oneOf(calculator).add(5.0, 3.0);
      will(returnValue(8.0));
    }});
    double result = calcUser.addNumbers(5.0, 3.0);
    assertEquals(8.0, result);
  }

  @Test
  public void testSub() {
    context.checking(new Expectations() {{
      oneOf(calculator).sub(7.0, 3.0);
      will(returnValue(4.0));
    }});
    double result = calcUser.subtractNumbers(7.0, 3.0);
    assertEquals(4.0, result);
  }
}
