package com.clouway.gui.progressbar;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    MyProgressbar progressbar = new MyProgressbar();
    progressbar.setLocation(500,200);
    progressbar.setSize(200,100);
    progressbar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    progressbar.setVisible(true);
  }
}
