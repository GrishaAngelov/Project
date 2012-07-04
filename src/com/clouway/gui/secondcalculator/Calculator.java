package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Calculator extends JFrame {
  private JTextField textField;
  private Container numberContainer;
  private Container operationContainer;
  private Container mainContainer;
  private ButtonCreator buttonCreator;
  private ButtonCreator buttonOperationCreator;
  private ButtonCreator specialButtonCreator;

  public Calculator() {
    setTitle("calculator");
    setUpMainContainer();
    setUpTextField();
    setUpNumberAndOperationContainers();
  }

  private void setUpMainContainer() {
    mainContainer = getContentPane();
    mainContainer.setLayout(new FlowLayout());
    mainContainer.setBackground(Color.ORANGE);
  }

  private void setUpTextField() {
    textField = new JTextField();
    textField.setColumns(20);
    textField.setEditable(false);
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    add(textField);
  }

  private void setUpNumberAndOperationContainers() {
    numberContainer = new Container();
    numberContainer.setBackground(Color.ORANGE);
    numberContainer.setLayout(new GridLayout(4, 3, 5, 5));

    operationContainer = new Container();
    operationContainer.setBackground(Color.ORANGE);
    operationContainer.setLayout(new GridLayout(3, 3, 5, 5));

    String[] buttonNumberLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    String[] buttonOperationLabel = {"+", "-", "*", "/"};

    buttonCreator = new ButtonCreator(buttonNumberLabel, new ButtonHandler(textField));
    buttonCreator.setContainers(mainContainer, numberContainer);
    buttonCreator.createButtons();
    add(numberContainer, BorderLayout.WEST);

    buttonOperationCreator = new ButtonCreator(buttonOperationLabel, new OperationButtonHandler(textField));
    buttonOperationCreator.setContainers(mainContainer, operationContainer);
    buttonOperationCreator.createButtons();
    add(operationContainer, BorderLayout.EAST);

    specialButtonCreator = new ButtonCreator(".", new DotButtonHandler(textField));
    specialButtonCreator.setContainers(mainContainer, operationContainer);
    specialButtonCreator.createSingleButton();
    add(operationContainer, BorderLayout.EAST);

    specialButtonCreator = new ButtonCreator("<-", new ClearLastDigitButtonHandler(textField));
    specialButtonCreator.setContainers(mainContainer, operationContainer);
    specialButtonCreator.createSingleButton();
    add(operationContainer, BorderLayout.EAST);
  }
}
