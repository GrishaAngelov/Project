package com.clouway.gui.calculator;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    Calculator calc = new Calculator();
    calc.setLocation(500, 200);
    calc.setSize(300, 200);
    calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calc.setResizable(false);
    calc.setVisible(true);
  }
}
