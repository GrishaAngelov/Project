package com.clouway.gui.calculatortask;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonBuilderImpl implements ButtonBuilder {

//  public List<JButton> buildButtons(String[] buttonLabel, ActionListener listener) {
//    List<JButton> buttonList = new ArrayList<JButton>();
//
//    for (int i = 0; i < buttonLabel.length; i++) {
//      JButton button = new JButton(buttonLabel[i]);
//      button.addActionListener(listener);
//      buttonList.add(button);
//    }
//    return buttonList;
//  }

  public JButton buildButton(String buttonLabel, ActionListener listener){
    JButton button = new JButton(buttonLabel);
    button.addActionListener(listener);
    return button;
  }
}
