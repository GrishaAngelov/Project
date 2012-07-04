package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonHandler implements ActionListener {
  private JTextField textField;


  public ButtonHandler(JTextField textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    String buttonLabel = ((JButton) event.getSource()).getText();
    textField.setText(textField.getText() + buttonLabel);
  }
}
