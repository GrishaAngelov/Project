package com.clouway.gui.thirdcalculator;


import java.util.EventListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ActionListenerWrapper extends EventListener {

  public void actionPerformed(CalculatorTextField textField);
}
