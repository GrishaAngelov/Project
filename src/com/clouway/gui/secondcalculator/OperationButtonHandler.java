package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class OperationButtonHandler implements ActionListener {

  private JTextField textField;
  private NumbersHolder numbersHolder;

  public OperationButtonHandler(JTextField textField, NumbersHolder numbersHolder) {
    this.textField = textField;
    this.numbersHolder = numbersHolder;
  }

  public void actionPerformed(ActionEvent event) {
    if (textField.getText().length() == 0) {
      textField.setText("");
    } else {
      numbersHolder.setFirstNum(Double.parseDouble(textField.getText()));
      numbersHolder.setOperation(((JButton) event.getSource()).getText());
      textField.setText("");
    }
  }
}
