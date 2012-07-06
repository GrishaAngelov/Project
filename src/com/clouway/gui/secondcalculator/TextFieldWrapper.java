package com.clouway.gui.secondcalculator;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TextFieldWrapper extends JTextField implements HasText {
  private final JTextField textField;

  public TextFieldWrapper(JTextField textField){
    this.textField = textField;
  }


  @Override
  public String getTextValue() {
    return textField.getText();
  }

  @Override
  public void setTextValue(String text) {
    textField.setText(text);
  }
}
