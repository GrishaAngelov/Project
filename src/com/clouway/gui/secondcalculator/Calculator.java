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

    String[] buttonNumberLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    add(new ButtonCreator(buttonNumberLabel, new ButtonHandler(textField), mainContainer, numberContainer).createButtons(), BorderLayout.WEST);
    operationContainer = new Container();
    operationContainer.setBackground(Color.ORANGE);
    operationContainer.setLayout(new GridLayout(3, 3, 5, 5));

    Operator operator = new Operator();
    NumbersHolder numbersHolder = new NumbersHolder();
    String[] buttonOperationLabel = {"+", "-", "*", "/"};

    TextFieldWrapper textFieldWrapper = new TextFieldWrapper(textField);
    ActionListenerWrapper actionListenerWrapperClearAll = new ActionListenerWrapperClearAll();
    ActionListenerWrapper actionListenerWrapperDot = new ActionListenerWrapperDot();

    add(new ButtonCreator(buttonOperationLabel, new OperationButtonHandler(textField, numbersHolder), mainContainer, operationContainer).createButtons(), BorderLayout.EAST);

//    add(new ButtonCreator(new String[]{"."}, new DotButtonHandler(textField), mainContainer, operationContainer).createButtons(), BorderLayout.EAST);
    add(new ButtonCreator(new String[]{"."}, new DotButtonHandler(actionListenerWrapperDot, textFieldWrapper), mainContainer, operationContainer).createButtons(), BorderLayout.EAST);
    add(new ButtonCreator(new String[]{"<-"}, new ClearLastSymbolButtonHandler(textField), mainContainer, operationContainer).createButtons(), BorderLayout.EAST);

//    add(new ButtonCreator(new String[]{"clr"}, new ClearAllHandler(textField), mainContainer, operationContainer).createButtons(), BorderLayout.EAST);
    add(new ButtonCreator(new String[]{"clr"}, new ClearAllHandler(actionListenerWrapperClearAll, textFieldWrapper), mainContainer, operationContainer).createButtons(), BorderLayout.EAST);
    add(new ButtonCreator(new String[]{"="}, new EqualsHandler(textField, operator, numbersHolder), mainContainer, operationContainer).createButtons(), BorderLayout.EAST);
  }
}
