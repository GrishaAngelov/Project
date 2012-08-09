package com.clouway.gui.calculatortask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class FunctionalButtonListener implements ActionListener {
  private ActionListenerWrapper listener;
  private HasText text;

  public FunctionalButtonListener(ActionListenerWrapper listener, HasText text) {
    this.listener = listener;
    this.text = text;
  }

  public void actionPerformed(ActionEvent event) {
    listener.actionPerformed(text);
  }
}
