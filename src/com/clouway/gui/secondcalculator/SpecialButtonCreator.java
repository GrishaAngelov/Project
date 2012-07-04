package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SpecialButtonCreator {
  private String buttonLabel;
  private ActionListener actionListener;

  public SpecialButtonCreator(String buttonLabel, ActionListener actionListener) {
    this.buttonLabel = buttonLabel;
    this.actionListener = actionListener;
  }

  public void create(){
    JButton button = new JButton(buttonLabel);
    button.addActionListener(actionListener);
  }
}
