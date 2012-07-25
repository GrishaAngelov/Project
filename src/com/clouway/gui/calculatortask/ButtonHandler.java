package com.clouway.gui.calculatortask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonHandler implements ActionListener {
  private CalculatorTextField textField;

  public ButtonHandler(CalculatorTextField textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    JButton button = (JButton) event.getSource();
    textField.setFieldText(textField.getFieldText() + button.getText());
  }
}
