package com.clouway.gui.secondcalculator;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    calculator.setLocation(500, 200);
    calculator.setSize(350, 200);
    calculator.setVisible(true);
//    calculator.setResizable(false);
    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
