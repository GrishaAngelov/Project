package com.clouway.gui.examplesfrombook.radiobuttonframe;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
    radioButtonFrame.setLocation(500,500);
    radioButtonFrame.setSize(300,150);
    radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    radioButtonFrame.setVisible(true);
  }
}
