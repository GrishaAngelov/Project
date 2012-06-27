package com.clouway.gui.examplesfrombook.paint;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Painter {
  public static void main(String[] args) {
    JFrame application = new JFrame("A simple paint program");

    PaintPanel paintPanel = new PaintPanel();
    application.add(paintPanel, BorderLayout.CENTER);
    application.add(new JLabel("Drag the mouse to draw"),BorderLayout.SOUTH);
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.setSize(500, 600);
    application.setLocation(500,200);
    application.setVisible(true);
  }
}
