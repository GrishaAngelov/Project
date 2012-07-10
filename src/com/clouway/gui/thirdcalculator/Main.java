package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    ButtonCreator buttonCreator = new ButtonCreator();
    List<JButton> buttonList = buttonCreator.createButtons(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
    List<JButton> operationButtons = buttonCreator.createButtons(new String[]{"+","-", "*", "/"});
    Calculator calculator = new Calculator(buttonList,operationButtons);
    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculator.setLocation(500, 200);
    calculator.setSize(250, 200);
    calculator.setVisible(true);
  }
}
