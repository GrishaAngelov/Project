package com.clouway.gui.examplesfrombook.checkboxframe;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    CheckboxFrame checkboxFrame = new CheckboxFrame();
    checkboxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    checkboxFrame.setLocation(500, 500);
    checkboxFrame.setSize(300, 100);
    checkboxFrame.setVisible(true);
  }
}
