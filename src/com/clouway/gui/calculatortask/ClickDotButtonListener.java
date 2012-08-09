package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClickDotButtonListener implements ActionListenerWrapper {
  public void actionPerformed(HasText text) {
    text.setFieldText(text.getFieldText() + ".");
  }
}