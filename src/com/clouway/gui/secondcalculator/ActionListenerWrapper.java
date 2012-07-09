package com.clouway.gui.secondcalculator;

import java.awt.event.ActionListener;
import java.util.EventListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ActionListenerWrapper extends EventListener {

  public void actionPerformed(TextFieldWrapper textFieldWrapper);
}
