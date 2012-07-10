package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonListenerAssigner {
  private List butonList;
  private ActionListener actionListener;

  public ButtonListenerAssigner(List butonList, ActionListener actionListener){
    this.butonList = butonList;
    this.actionListener = actionListener;
  }

  public void assign(){
    for (int i = 0; i < butonList.size(); i++) {
      JButton button = (JButton)butonList.get(i);
      button.addActionListener(actionListener);
    }
  }

  public List getAssignedButtonList(){
    return butonList;
  }
}
