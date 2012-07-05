package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearAllHandler implements ActionListener {
  private JTextField textField;

  public ClearAllHandler(JTextField textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    textField.setText("");
  }
}
