package com.clouway.gui.calculatortask;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalculatorDisplay implements HasText {
  private JTextField textField;

  public CalculatorDisplay(JTextField textField) {
    this.textField = textField;
    textField.setColumns(20);
    textField.setEditable(false);
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
  }

  public void setFieldText(String text) {
    textField.setText(text);
  }

  public String getFieldText() {
    return textField.getText();
  }
}
