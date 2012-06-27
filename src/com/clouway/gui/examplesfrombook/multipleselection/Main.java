package com.clouway.gui.examplesfrombook.multipleselection;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    MultipleSelectionFrame multipleSelectionFrame = new MultipleSelectionFrame();
    multipleSelectionFrame.setLocation(500,200);
    multipleSelectionFrame.setSize(500,200);
    multipleSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    multipleSelectionFrame.setVisible(true);
  }
}
