package com.clouway.gui.calculatortask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SpecialButtonHandler implements ActionListener {
  private ActionListenerWrapper listener;
  private CalculatorTextField textField;

  public SpecialButtonHandler(ActionListenerWrapper listener, CalculatorTextField textField) {
    this.listener = listener;
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    listener.actionPerformed(textField);
  }
}
