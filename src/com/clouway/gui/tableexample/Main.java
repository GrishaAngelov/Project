package com.clouway.gui.tableexample;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    MyTableClass tableClass = new MyTableClass();
    tableClass.setLocation(500,200);
    tableClass.setSize(300,100);
    tableClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tableClass.setVisible(true);
  }
}
