package com.clouway.gui.examplesfrombook.mouseadapter;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame();
    mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mouseDetailsFrame.setLocation(500,200);
    mouseDetailsFrame.setSize(400,150);
    mouseDetailsFrame.setVisible(true);
  }
}
