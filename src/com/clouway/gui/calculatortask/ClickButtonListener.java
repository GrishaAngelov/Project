package com.clouway.gui.calculatortask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClickButtonListener implements ActionListener {
  private HasText text;

  public ClickButtonListener(HasText text) {
    this.text = text;
  }

  public void actionPerformed(ActionEvent event) {
    JButton button = (JButton) event.getSource();
    text.setFieldText(text.getFieldText() + button.getText());
  }
}
