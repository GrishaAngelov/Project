package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearLastSymbolButtonHandler implements ActionListener {
  private JTextField textField;

  public ClearLastSymbolButtonHandler(JTextField textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    if (textField.getText().length() == 0) {
      textField.setText("");
    } else {
      textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
    }
  }
}
