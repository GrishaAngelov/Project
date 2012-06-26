package com.clouway.gui.buttonexample;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    ButtonClass buttonClass = new ButtonClass();

    buttonClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buttonClass.setSize(250, 100);
    buttonClass.setLocation(500,200);
    buttonClass.setVisible(true);
  }
}
