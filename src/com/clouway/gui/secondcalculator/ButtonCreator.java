package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonCreator {
  private String[] buttonLabel;
  private String label;
  private ActionListener actionListener;
  private Container mainContainer;
  private Container componentContainer;

  public ButtonCreator(String buttonLabel, ActionListener actionListener){
    this.label = buttonLabel;
    this.actionListener = actionListener;

  }

  public ButtonCreator(String[] buttonLabel, ActionListener actionListener) {
    this.buttonLabel = buttonLabel;
    this.actionListener = actionListener;
  }

  public void setContainers(Container mainContainer, Container componentContainer) {
    this.mainContainer = mainContainer;
    this.componentContainer = componentContainer;
  }


  public void createButtons() {

    for (int i = 0; i < buttonLabel.length; i++) {
      JButton numberButton = new JButton(buttonLabel[i]);
      numberButton.addActionListener(actionListener);
      componentContainer.add(numberButton);
    }
    mainContainer.add(componentContainer, BorderLayout.WEST);
  }

  public void createSingleButton(){
    JButton button = new JButton(label);
    button.addActionListener(actionListener);
    componentContainer.add(button);
    mainContainer.add(componentContainer, BorderLayout.WEST);
  }
}
