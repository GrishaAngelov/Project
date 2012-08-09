package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearLastSymbolListener implements ActionListenerWrapper {
  public void actionPerformed(CalculatorTextField textField) {
    textField.setFieldText(textField.getFieldText().substring(0, textField.getFieldText().length() - 1));
  }
}
