package com.clouway.gui.examplesfrombook.layoutmanagers.flowlayout;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    FlowLayoutFrame flowLayoutFrame = new FlowLayoutFrame();
    flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    flowLayoutFrame.setSize(300, 75); // set frame size
    flowLayoutFrame.setLocation(500,400);
    flowLayoutFrame.setVisible(true); //
  }
}
