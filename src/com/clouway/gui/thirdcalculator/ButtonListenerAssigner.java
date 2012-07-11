package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonListenerAssigner {
  private List<JButton> buttonList;
  private ActionListener actionListener;

  public ButtonListenerAssigner(){

  }

  public ButtonListenerAssigner(List<JButton> buttonList, ActionListener actionListener){
    this.buttonList = buttonList;
    this.actionListener = actionListener;
  }

  public List<JButton> assignListenerToButtonList(){
    for (int i = 0; i < buttonList.size(); i++) {
      JButton button = buttonList.get(i);
      button.addActionListener(actionListener);
    }
    return buttonList;
  }

  public JButton assignListenerToSingleButton(JButton button, ActionListener actionListener){
    button.addActionListener(actionListener);
    return button;
  }
}
