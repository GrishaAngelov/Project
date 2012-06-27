package com.clouway.gui.examplesfrombook.mousetracker;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
    mouseTrackerFrame.setLocation(500, 300);
    mouseTrackerFrame.setSize(400, 200);
    mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mouseTrackerFrame.setVisible(true);
  }
}
