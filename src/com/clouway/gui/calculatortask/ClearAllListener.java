package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearAllListener implements ActionListenerWrapper {

  public void actionPerformed(HasText text) {
    text.setFieldText("");
  }
}