package com.clouway.testingwithmocks.tasks.service;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServiceTest {

  private Mockery context = new JUnit4Mockery();
  private DB db = context.mock(DB.class);
  private Service service;


  @Before
  public void setUp() {
    service = new Service(db);
  }

  @Test
  public void testAddCorrectAge() {
    context.checking(new Expectations() {{
      oneOf(db).addPerson("John", "21");
    }});
    service.addPerson("John", "21");
  }

  @Test(expected = IncorrectAgeValueException.class)
  public void testAddBigValueAge() {
    context.checking(new Expectations() {{
      oneOf(db).addPerson("John", "150");
      will(throwException(new IncorrectAgeValueException()));
    }});
    service.addPerson("John", "150");
  }

  @Test
  public void testGetCorrectAge() {
    context.checking(new Expectations() {{
      oneOf(db).getPersonAge("John");
      will(returnValue("19"));
    }});
   assertEquals(true, service.getPersonAge("John"));
  }

  @Test(expected = IncorrectAgeValueException.class)
  public void testGetIncorrectAge() {
    context.checking(new Expectations() {{
      oneOf(db).getPersonAge("Peter");
      will(returnValue("10"));
      will(throwException(new IncorrectAgeValueException()));
    }});
    assertEquals(false, service.getPersonAge("Peter"));
  }
}
