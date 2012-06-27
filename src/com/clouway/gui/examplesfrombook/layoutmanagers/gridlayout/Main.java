package com.clouway.gui.examplesfrombook.layoutmanagers.gridlayout;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    MyGridLayout myGridLayout = new MyGridLayout();
    myGridLayout.setLocation(500,500);
    myGridLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myGridLayout.setSize(300,300);
    myGridLayout.setVisible(true);
  }
}
