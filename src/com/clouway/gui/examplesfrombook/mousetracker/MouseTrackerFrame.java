package com.clouway.gui.examplesfrombook.mousetracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MouseTrackerFrame extends JFrame {
  private JPanel mousePanel;
  private JLabel statusbar;
  private MouseHandler mouseHandler = new MouseHandler();

  public MouseTrackerFrame() {
    super("Mouse Events");

    mousePanel = new JPanel();
    mousePanel.setBackground(Color.WHITE);
    add(mousePanel, BorderLayout.CENTER);

    statusbar = new JLabel("Mouse is outside the panel");
    add(statusbar, BorderLayout.SOUTH);

    mousePanel.addMouseListener(mouseHandler);
    mousePanel.addMouseMotionListener(mouseHandler);
  }

  private class MouseHandler implements MouseListener, MouseMotionListener {

    // MouseListener event handlers
    // Handle the event when mouse released immediately after press

    public void mouseClicked(MouseEvent mouseEvent) {
      statusbar.setText(String.format("Clicked at [%d, %d]", mouseEvent.getX(), mouseEvent.getY()));
    }

    public void mousePressed(MouseEvent mouseEvent) {
      statusbar.setText(String.format("Pressed at [%d, %d]", mouseEvent.getX(), mouseEvent.getY()));
    }

    public void mouseReleased(MouseEvent mouseEvent) {
      statusbar.setText(String.format("Released at [%d, %d]", mouseEvent.getX(), mouseEvent.getY()));
    }

    public void mouseEntered(MouseEvent mouseEvent) {
      statusbar.setText(String.format("Mouse entered at [%d, %d]", mouseEvent.getX(), mouseEvent.getY()));
      mousePanel.setBackground(Color.GREEN);
    }

    public void mouseExited(MouseEvent mouseEvent) {
      statusbar.setText("Mouse outside panel");
      mousePanel.setBackground(Color.WHITE);
    }

    // MouseMotionListener event handlers
    // handle event when user drags mouse with button pressed

    public void mouseDragged(MouseEvent mouseEvent) {
      statusbar.setText(String.format("Dragged at [%d, %d]", mouseEvent.getX(), mouseEvent.getY()));
    }

    public void mouseMoved(MouseEvent mouseEvent) {
      statusbar.setText(String.format("Moved at [%d, %d]", mouseEvent.getX(), mouseEvent.getY()));
    }
  }

}
