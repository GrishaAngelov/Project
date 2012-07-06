package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearAllHandler implements ActionListener {
  private ActionListenerWrapper listener;
  private HasText textBox;

  public ClearAllHandler(ActionListenerWrapper listener, HasText textBox) {
    this.listener = listener;
    this.textBox = textBox;
  }

  public void actionPerformed(ActionEvent event) {

    final JButton button = (JButton) event.getSource();
    listener.actionPerformed(textBox);
  }
}
