package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearLastSymbolListener implements ActionListenerWrapper {
  public void actionPerformed(HasText text) {
    text.setFieldText(text.getFieldText().substring(0, text.getFieldText().length() - 1));
  }
}
