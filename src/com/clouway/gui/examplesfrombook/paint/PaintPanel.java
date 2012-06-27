package com.clouway.gui.examplesfrombook.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PaintPanel extends JPanel {
  private int pointCount = 0;
  private Point[] points = new Point[10000];

  public PaintPanel() {
    addMouseMotionListener(
            new MouseAdapter() {

              public void mouseDragged(MouseEvent mouseEvent) {
                if (pointCount < points.length) {
                  points[pointCount] = mouseEvent.getPoint();
                  pointCount++;
                  repaint();
                }
              }
            }
    );
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // clears drawing area

    // draw all points in array
    for (int i = 0; i < pointCount; i++)
      g.fillOval(points[i].x, points[i].y, 6, 6);
  }
}
