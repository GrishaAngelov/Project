package com.clouway.gui.thirdcalculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalculatorTextFieldImplTest {
  private CalculatorTextFieldImpl textField;

  @Before
  public void setUp(){
    textField = new CalculatorTextFieldImpl(new JTextField());
  }

  @Test
  public void textFieldFunctionality(){
    textField.setFieldText("12");
    assertEquals("12", textField.getFieldText());
  }
}
