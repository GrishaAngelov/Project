package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class OperationButtonHandler implements ActionListener {

  private CalculatorTextField textField;
  private OperandsAndOperationProvider operandsAndOperationProvider;

  public OperationButtonHandler(CalculatorTextField textField, OperandsAndOperationProvider operandsAndOperationProvider) {
    this.textField = textField;
    this.operandsAndOperationProvider = operandsAndOperationProvider;
  }

  public void actionPerformed(ActionEvent event) {
    if (textField.getFieldText().length() == 0) {
      textField.setFieldText("");
    } else {
      operandsAndOperationProvider.setFirstNumber(Double.parseDouble(textField.getFieldText()));
      operandsAndOperationProvider.setOperation(((JButton) event.getSource()).getText());
      textField.setFieldText("");
    }
  }
}
