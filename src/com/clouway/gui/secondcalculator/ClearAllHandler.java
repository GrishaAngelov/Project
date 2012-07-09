package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearAllHandler implements ActionListener {
  private ActionListenerWrapper listener;
  private TextFieldWrapper textFieldWrapper;

  public ClearAllHandler(ActionListenerWrapper listener, TextFieldWrapper textFieldWrapper) {
    this.listener = listener;
    this.textFieldWrapper = textFieldWrapper;
  }

  public void actionPerformed(ActionEvent event) {
//    final JButton button = (JButton) event.getSource();
    listener.actionPerformed(textFieldWrapper);
  }
}
