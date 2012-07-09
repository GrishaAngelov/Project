package com.clouway.gui.secondcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ActionListenerWrapperDot implements ActionListenerWrapper {
  public void actionPerformed(TextFieldWrapper textFieldWrapper) {
    textFieldWrapper.setTextValue(textFieldWrapper.getTextValue() + ".");
  }
}
