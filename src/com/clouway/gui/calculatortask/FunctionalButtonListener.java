package com.clouway.gui.calculatortask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class FunctionalButtonListener implements ActionListener {
  private ActionListenerWrapper listener;
  private CalculatorTextField textField;

  public FunctionalButtonListener(ActionListenerWrapper listener, CalculatorTextField textField) {
    this.listener = listener;
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    listener.actionPerformed(textField);
  }
}
