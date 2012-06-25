package com.clouway.gui.examplesfrombook.integersumator;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class IntegerSumator {
  public static void main(String[] args) {
    JOptionPane jOptionPane = new JOptionPane();

    String firstNum = jOptionPane.showInputDialog("Enter first number");
    String secondNum = jOptionPane.showInputDialog("Enter second number");

    try {
      int firstNumber = Integer.parseInt(firstNum);
      int secondNumber = Integer.parseInt(secondNum);
      int result = firstNumber + secondNumber;
      jOptionPane.showMessageDialog(null, "sum is: " + result, "result", JOptionPane.PLAIN_MESSAGE);
    } catch (NumberFormatException e) {
      jOptionPane.showMessageDialog(null, "Incorrect Input!", "result", JOptionPane.ERROR_MESSAGE);
    }
  }
}
