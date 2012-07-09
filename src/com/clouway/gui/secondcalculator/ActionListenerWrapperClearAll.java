package com.clouway.gui.secondcalculator;

import java.awt.event.ActionEvent;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ActionListenerWrapperClearAll implements ActionListenerWrapper {

  public void actionPerformed(TextFieldWrapper textFieldWrapper) {
    textFieldWrapper.setTextValue("");
  }
}
