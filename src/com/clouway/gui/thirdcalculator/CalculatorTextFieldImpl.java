package com.clouway.gui.thirdcalculator;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalculatorTextFieldImpl extends JTextField implements CalculatorTextField {
  private JTextField textField;

  public CalculatorTextFieldImpl(JTextField textField){
    this.textField = textField;
  }

  public void setFieldText(String text){
    textField.setText(text);
  }

  public String getFieldText(){
    return textField.getText();
  }
}
