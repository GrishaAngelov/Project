package com.clouway.gui.examplesfrombook.layoutmanagers.borderlayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BorderLayoutClass extends JFrame {
  private JButton northButton;
  private JButton southButton;
  private JButton eastButton;
  private JButton westButton;
  private JButton centerButton;
  private BorderLayout borderLayout;

  public BorderLayoutClass(){
    super("Border layout");
    northButton = new JButton("North");
    southButton = new JButton("South");
    eastButton = new JButton("East");
    westButton = new JButton("West");
    centerButton = new JButton("Center");
    borderLayout = new BorderLayout(5,10);
    setLayout(borderLayout);
    add(northButton,BorderLayout.NORTH);
    add(southButton,BorderLayout.SOUTH);
    add(eastButton,BorderLayout.EAST);
    add(centerButton,BorderLayout.CENTER);
    add(westButton,BorderLayout.WEST);
  }
}
