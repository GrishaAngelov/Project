package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonNumberHandler implements ActionListener {
  private CalculatorTextFieldImpl textField;

  public ButtonNumberHandler(CalculatorTextFieldImpl textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    JButton button = (JButton) event.getSource();
    textField.setText(textField.getText() + button.getText());
  }
}
