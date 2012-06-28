package com.clouway.gui.changetouppercase;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    UpperCaseChanger upperCaseChanger = new UpperCaseChanger();
    upperCaseChanger.setLocation(500,200);
    upperCaseChanger.setSize(200,200);
    upperCaseChanger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    upperCaseChanger.setVisible(true);
  }
}
