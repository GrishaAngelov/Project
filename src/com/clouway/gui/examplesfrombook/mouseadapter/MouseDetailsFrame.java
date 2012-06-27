package com.clouway.gui.examplesfrombook.mouseadapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MouseDetailsFrame extends JFrame {
  private String details;
  private JLabel statusBar;

  public MouseDetailsFrame() {
    super("Mouse clicks");

    statusBar = new JLabel("Click the mouse");
    add(statusBar, BorderLayout.SOUTH);
    addMouseListener(new MouseClickHandler());
//    add(statusBar);
  }

  private class MouseClickHandler extends MouseAdapter {
    public void mouseClicked(MouseEvent mouseEvent){
      details="";
      if(mouseEvent.isMetaDown()){
        details += "click with right mouse button";
      }
      else if(mouseEvent.isAltDown()){
        details += "click with middle mouse button";
      }
      else{
        details += "click with left mouse button";
      }
      statusBar.setText(details);
      statusBar.setHorizontalAlignment(SwingConstants.CENTER);
    }
  }
}
