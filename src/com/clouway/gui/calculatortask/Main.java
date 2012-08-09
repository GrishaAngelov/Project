package com.clouway.gui.calculatortask;

import javax.swing.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    CalculatorUI calculatorUI = new CalculatorUI();
    calculatorUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculatorUI.setLocation(500, 200);
    calculatorUI.setSize(260, 200);
    calculatorUI.setVisible(true);
  }
}
