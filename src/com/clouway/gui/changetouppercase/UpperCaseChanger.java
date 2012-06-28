package com.clouway.gui.changetouppercase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UpperCaseChanger extends JFrame {
  private JTextField textField;
  private JButton button;
  private ButtonHandler handler = new ButtonHandler();

  public UpperCaseChanger() {
    setTitle("UpperCase");
    setLayout(new FlowLayout());
    textField = new JTextField();
    textField.setColumns(10);
    button = new JButton("ToUpperCase");
    button.addActionListener(handler);
    add(textField);
    add(button);
  }

  private class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String text = textField.getText();
      String newText = text.toUpperCase();
      text += text.toUpperCase();
      textField.setText(newText);
    }
  }
}
