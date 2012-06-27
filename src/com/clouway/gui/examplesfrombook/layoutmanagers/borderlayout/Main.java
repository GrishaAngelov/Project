package com.clouway.gui.examplesfrombook.layoutmanagers.borderlayout;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    BorderLayoutClass borderLayoutClass = new BorderLayoutClass();
    borderLayoutClass.setLocation(500,200);
    borderLayoutClass.setSize(300,400);
    borderLayoutClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    borderLayoutClass.setVisible(true);
  }
}
