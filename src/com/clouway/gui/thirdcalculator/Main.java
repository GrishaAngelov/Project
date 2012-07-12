package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    ButtonBuilder buttonBuilder = new ButtonBuilder();
    List<JButton> buttonList = buttonBuilder.createButtons(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"});
    List<JButton> operationButtons = buttonBuilder.createButtons(new String[]{"+","-", "*", "/"});
    List<JButton> specialButtons = buttonBuilder.createButtons(new String[]{"=",".","clr","<-"});
    Calculator calculator = new Calculator(buttonList,operationButtons,specialButtons);
    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculator.setLocation(500, 200);
    calculator.setSize(260, 200);
    calculator.setVisible(true);
  }
}
