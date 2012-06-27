package com.clouway.gui.examplesfrombook.layoutmanagers.gridlayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyGridLayout extends JFrame {
  private JButton firstButton;
  private JButton secondButton;
  private JButton thirdButton;
  private JButton fourthButton;
  private GridLayout myGridLayout;
  private Container container;

  public MyGridLayout() {
    super("Grid layout");
    myGridLayout = new GridLayout(3,3,5,5); // (rows,cols,hgap,vgap)
    container = getContentPane();
    container.setLayout(myGridLayout);
    firstButton = new JButton("first");
    secondButton = new JButton("second");
    thirdButton = new JButton("third");
    fourthButton = new JButton("fourth");
    add(firstButton);
    add(secondButton);
    add(thirdButton);
    add(fourthButton);
  }
}
