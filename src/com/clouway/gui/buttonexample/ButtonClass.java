package com.clouway.gui.buttonexample;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonClass extends JFrame {
  private JButton button;
  private MyButtonHandler handler = new MyButtonHandler();

  public ButtonClass() {
    super("Button Frame");
    button = new JButton("Click me");
    button.addActionListener(handler);
    add(button);
  }
}
