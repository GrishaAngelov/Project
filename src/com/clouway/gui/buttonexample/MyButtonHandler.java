package com.clouway.gui.buttonexample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyButtonHandler implements ActionListener {
  private TextFieldClass textFieldClass = new TextFieldClass();

  public void actionPerformed(ActionEvent event) {
    textFieldClass.setSize(250, 100);
    textFieldClass.setLocation(500,300);
    textFieldClass.setVisible(true);
  }
}
