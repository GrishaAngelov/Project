package com.clouway.testingwithmocks.abstractsystemjmockexample;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
@RunWith(JMock.class)
public class AbstractSystemUserTest {
  private Mockery context = new JUnit4Mockery();
  private AbstractSystem abstractSystem = context.mock(AbstractSystem.class);
  private AbstractSystemUser systemUser;

  @Before
  public void setUp() {
    systemUser = new AbstractSystemUser(abstractSystem);
  }

  @Test
  public void testTurnOnSystem(){
     context.checking(new Expectations(){{
       oneOf(abstractSystem).turnOnSystem();
       will(returnValue("The System is ON"));
     }});
    assertEquals("The System is ON", systemUser.turnOn());
  }

  @Test
  public void testDoMainSystemActivity(){
    context.checking(new Expectations(){{
      oneOf(abstractSystem).doMainSystemActivity();
      will(returnValue("System main activity in progress...."));
    }});
    assertEquals("System main activity in progress....",systemUser.doMainThing());
  }

  @Test
  public void testTurnOffSystem(){
    context.checking(new Expectations(){{
      oneOf(abstractSystem).turnOffSystem();
      will(returnValue("The System is OFF"));
    }});
    assertEquals("The System is OFF", systemUser.turnOff());
  }
}
