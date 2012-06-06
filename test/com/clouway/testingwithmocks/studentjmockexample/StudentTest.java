package com.clouway.testingwithmocks.studentjmockexample;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
@RunWith(JMock.class)
public class StudentTest {

  private Mockery context = new JUnit4Mockery();
  private DisciplineRegistration disciplineRegistration = context.mock(DisciplineRegistration.class);
  private Student student;

  @Before
  public void setUp() {
    student = new Student("John", disciplineRegistration);
  }

  @Test
  public void testRegisterThisStudentToDiscipline() {
    context.checking(new Expectations() {{
      oneOf(disciplineRegistration).registerStudentToDiscipline("Math");
      will(returnValue("Math"));
    }});

    String disciplineName = student.registerThisStudentToDiscipline("Math");
    assertEquals("Math", disciplineName);
  }
}
