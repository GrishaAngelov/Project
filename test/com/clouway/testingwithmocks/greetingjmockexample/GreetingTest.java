package com.clouway.testingwithmocks.greetingjmockexample;

import junit.framework.Assert;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
@RunWith(JMock.class)
public class GreetingTest {
  private Mockery context = new JUnit4Mockery();
  private GreetingManager greetingManager = context.mock(GreetingManager.class);

  private Greeting greeting;

  @Before
  public void setUp() {
    greeting = new Greeting(greetingManager);
  }

  @Test
  public void testCreateGreeting() {
    context.checking(new Expectations() {{
      oneOf(greetingManager).createGreet("Hello");
    }});
    greeting.setGreeting("Hello");
  }

  @Test
  public void testGetGreeting() {
    context.checking(new Expectations() {{
      oneOf(greetingManager).sayGreet();
      will(returnValue("Hello"));
    }});
    String message = greeting.getMyGreeting();
    Assert.assertEquals("Hello", message);
  }
}
