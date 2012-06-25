package com.clouway.gui.examplesfrombook.labelFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LabelTest {
  public static void main(String[] args) {
    LabelFrame frame = new LabelFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(500,100);
    frame.setSize(700,400);
    frame.setVisible(true);
  }
}
