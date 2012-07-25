package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalculatorTextFieldImplTest {
  private CalculatorTextFieldImpl textField;
  private JTextField field;

  @Before
  public void setUp(){
    field = new JTextField();
    textField = new CalculatorTextFieldImpl(field);
  }

  @Test
  public void textFieldFunctionality(){
    textField.setFieldText("12");
    assertEquals(textField.getFieldText(), field.getText());
  }

}
