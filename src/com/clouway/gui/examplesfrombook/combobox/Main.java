package com.clouway.gui.examplesfrombook.combobox;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
    comboBoxFrame.setLocation(500,200);
    comboBoxFrame.setSize(300,300);
    comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    comboBoxFrame.setVisible(true);
  }
}
