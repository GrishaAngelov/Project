package com.clouway.gui.passwordgenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PassButtonHandler implements ActionListener {
  private JTextField textField;
  private String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
  private int size = 8;
  private Random random = new Random();
  private StringBuilder stringBuilder = new StringBuilder();
  private Integer counter = 0;
  private JTextField counterField;

  public void setTextField(JTextField textField) {
    this.textField = textField;
  }

  public void setCounter(JTextField counterField) {
    this.counterField = counterField;
  }

  public void actionPerformed(ActionEvent event) {
    stringBuilder.delete(0, size);
    for (int i = 0; i < size; i++) {
      stringBuilder.append(symbols.charAt(random.nextInt(symbols.length())));
    }
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setText(stringBuilder.toString());
    counter++;
    counterField.setHorizontalAlignment(SwingConstants.CENTER);
    counterField.setText(counter.toString());
  }


}
