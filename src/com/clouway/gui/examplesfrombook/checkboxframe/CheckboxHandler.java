package com.clouway.gui.examplesfrombook.checkboxframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CheckboxHandler implements ItemListener {

  private int boldValue = Font.PLAIN;   //0
  private int italicValue = Font.PLAIN;
  private JCheckBox boldCheckBox;
  private JCheckBox italicCheckBox;
  private JTextField textField;

  public void setCheckbox(JCheckBox boldCheckBox, JCheckBox italicCheckBox) {
    this.boldCheckBox = boldCheckBox;
    this.italicCheckBox = italicCheckBox;
  }

  public void setTextfield(JTextField textfield) {
    this.textField = textfield;
  }

  public void itemStateChanged(ItemEvent itemEvent) {
    if (itemEvent.getSource() == boldCheckBox) {
      boldValue = boldCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
    }

    if (itemEvent.getSource() == italicCheckBox) {
      italicValue = italicCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
    }

    textField.setFont(new Font("Serif", boldValue + italicValue, 14));
  }
}
