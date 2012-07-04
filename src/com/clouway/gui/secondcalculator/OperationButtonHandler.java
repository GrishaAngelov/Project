package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class OperationButtonHandler implements ActionListener {
  private JTextField textField;

  public OperationButtonHandler( JTextField textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    String buttonLabel = ((JButton) event.getSource()).getText();
    textField.setText(buttonLabel);
  }
}
