package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ALWrapperDot implements ActionListenerWrapper {
  public void actionPerformed(CalculatorTextField textField) {
    textField.setFieldText(textField.getFieldText() + ".");
  }
}