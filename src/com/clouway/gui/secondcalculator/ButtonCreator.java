package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonCreator {
  private String[] buttonLabel;
  private ActionListener actionListener;
  private Container mainContainer;
  private Container componentContainer;

  public ButtonCreator(String[] buttonLabel, ActionListener actionListener, Container mainContainer, Container componentContainer) {
    this.buttonLabel = buttonLabel;
    this.actionListener = actionListener;
    this.mainContainer = mainContainer;
    this.componentContainer = componentContainer;
  }

  public Container createButtons() {
    for (int i = 0; i < buttonLabel.length; i++) {
      JButton numberButton = new JButton(buttonLabel[i]);
      numberButton.addActionListener(actionListener);
      componentContainer.add(numberButton);
    }
    mainContainer.add(componentContainer, BorderLayout.WEST);
    return componentContainer;
  }
}
