package com.clouway.gui.calculatortask;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    JFrame calculatorUI = new JFrame();

    calculatorUI.setTitle("Calculator");
    Container container = calculatorUI.getContentPane();
    container.setBackground(Color.ORANGE);
    calculatorUI.setLayout(new FlowLayout());
    calculatorUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculatorUI.setLocation(500, 200);
    calculatorUI.setSize(260, 200);
    calculatorUI.setVisible(true);

    JTextField field = new JTextField();
    HasText textField = new CalculatorDisplay(field);
    ClickDotButtonListener clickDotButtonListener = new ClickDotButtonListener();
    ClearAllListener clearAllListener = new ClearAllListener();
    ClearLastSymbolListener clearLastSymbolListener = new ClearLastSymbolListener();
    ButtonBuilder buttonBuilder = new ButtonBuilderImpl();

    calculatorUI.add(field);

    String[] buttonTitles = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/"};
    for (String buttonTitle : buttonTitles) {
      calculatorUI.add(buttonBuilder.buildButton(buttonTitle, new ClickButtonListener(textField)));
    }

    calculatorUI.add(buttonBuilder.buildButton("=", new EqualsButtonListener(textField)));
    calculatorUI.add(buttonBuilder.buildButton(".", new FunctionalButtonListener(clickDotButtonListener, textField)));
    calculatorUI.add(buttonBuilder.buildButton("clr", new FunctionalButtonListener(clearAllListener, textField)));
    calculatorUI.add(buttonBuilder.buildButton("<-", new FunctionalButtonListener(clearLastSymbolListener, textField)));

    calculatorUI.setResizable(false);
  }
}
