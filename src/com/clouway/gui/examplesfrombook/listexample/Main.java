package com.clouway.gui.examplesfrombook.listexample;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    ListFrame listFrame = new ListFrame();
    listFrame.setLocation(500,200);
    listFrame.setSize(200,300);
    listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    listFrame.setVisible(true);
  }
}
