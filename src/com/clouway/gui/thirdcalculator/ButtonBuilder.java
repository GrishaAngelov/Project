package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonBuilder implements ButtonCreatorInterface {

  public List<JButton> createButtons(String[] buttonLabel){
    List<JButton> buttonList = new ArrayList<JButton>();

    for (int i = 0; i < buttonLabel.length; i++) {
      JButton button = new JButton(buttonLabel[i]);
      buttonList.add(button);
    }
    return buttonList;
  }
}
