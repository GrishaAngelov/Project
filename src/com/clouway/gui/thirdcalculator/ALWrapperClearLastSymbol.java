package com.clouway.gui.thirdcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ALWrapperClearLastSymbol implements ActionListenerWrapper {
  public void actionPerformed(CalculatorTextField textField) {
    textField.setFieldText(textField.getFieldText().substring(0, textField.getFieldText().length() - 1));
  }
}
