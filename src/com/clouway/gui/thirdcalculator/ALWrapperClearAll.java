package com.clouway.gui.thirdcalculator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ALWrapperClearAll implements ActionListenerWrapper {

  public void actionPerformed(CalculatorTextField textField) {
    textField.setFieldText("");
  }
}
