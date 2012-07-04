package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearLastDigitButtonHandler implements ActionListener {
  private JTextField textField;

  public ClearLastDigitButtonHandler(JTextField textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
  }
}
