package com.clouway.gui.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Calculator extends JFrame {

  private JButton clearButton;
  private JButton equalsButton;
  private JButton dotButton;
  private JButton clearLastDigitButton;
  private JTextField textField;
  private GridLayout layout;
  private Container container;
  private EqualsButtonHandler equalsButtonHandler;
  private DotButtonHandler dotButtonHandler;
  private ClearButtonHandler clearButtonHandler;
  private ClearLastDigitButtonHandler clearLastDigitButtonHandler;
  private Operator operator = new Operator();
  private int firstNumber = 0;
  private int secondNumber = 0;
  private String character;
  private Hashtable<String, Integer> table = new Hashtable<String, Integer>();

  public void setTheLayout() {
    layout = new GridLayout(4, 3, 5, 5);
    container = getContentPane();
    container.setLayout(layout);
  }

  public void createButtons() {
    clearButton = new JButton("CLR");
    equalsButton = new JButton("=");
    dotButton = new JButton(".");
    clearLastDigitButton = new JButton("<-");
  }

  public void setTextField() {
    textField = new JTextField();
    textField.setEditable(false);
//    textField.setColumns(25);
  }

  public void createHandlers() {
    String[] buttonLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    List<ButtonHandler> buttonHandlerList = new ArrayList<ButtonHandler>();

    add(textField);
    for (int i = 0; i < buttonLabel.length; i++) {

      ButtonHandler buttonHandler = new ButtonHandler(buttonLabel[i]);
      buttonHandlerList.add(buttonHandler);

      JButton button = new JButton(buttonLabel[i]);
      button.addActionListener(buttonHandler);
      add(button);
    }
    add(equalsButton);
    add(clearButton);
    add(dotButton);
    add(clearLastDigitButton);

    String[] operationButtonLabel = {"+", "-", "*", "/"};
    List<OperatorHandler> operatorHandlerList = new ArrayList<OperatorHandler>();

    for (int i = 0; i < operationButtonLabel.length; i++) {
      OperatorHandler operatorHandler = new OperatorHandler(operationButtonLabel[i]);
      operatorHandlerList.add(operatorHandler);

      JButton operationButton = new JButton(operationButtonLabel[i]);
      operationButton.addActionListener(operatorHandler);
      add(operationButton);
    }

    equalsButtonHandler = new EqualsButtonHandler();
    clearButtonHandler = new ClearButtonHandler();
    dotButtonHandler = new DotButtonHandler();
    clearLastDigitButtonHandler = new ClearLastDigitButtonHandler();
  }

  public void addActionListeners() {
    equalsButton.addActionListener(equalsButtonHandler);
    clearButton.addActionListener(clearButtonHandler);
    dotButton.addActionListener(dotButtonHandler);
    clearLastDigitButton.addActionListener(clearLastDigitButtonHandler);
  }


  public void setTableContent() {
    table.put("+", operator.add(firstNumber, secondNumber));
    table.put("-", operator.sub(firstNumber, secondNumber));
    table.put("*", operator.mul(firstNumber, secondNumber));
    table.put("/", operator.div(firstNumber, secondNumber));
  }

  public Calculator() {
    setTitle("Calculator");
    setTheLayout();
    createButtons();
    setTextField();
    createHandlers();
    addActionListeners();
  }

  private class ButtonHandler implements ActionListener {
    String buttonTitle;

    public ButtonHandler(String buttonTitle) {
      this.buttonTitle = buttonTitle;
    }

    public void actionPerformed(ActionEvent event) {
      textField.setText(textField.getText() + buttonTitle);
    }
  }

  private class OperatorHandler implements ActionListener {
    String operationCharacter;

    public OperatorHandler(String operationCharacter) {
      this.operationCharacter = operationCharacter;
    }

    public void actionPerformed(ActionEvent event) {
      firstNumber = Integer.parseInt(textField.getText());
      textField.setText("");
      character = operationCharacter;
      dotButton.setEnabled(true);
    }
  }

  private class ClearButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      textField.setText("");
      firstNumber = 0;
      secondNumber = 0;
    }
  }

  private class EqualsButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      secondNumber = Integer.parseInt(textField.getText());
      setTableContent();
      textField.setText(table.get(character).toString());
    }
  }

  private class DotButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      textField.setText(textField.getText() + ".");
      dotButton.setEnabled(false);
    }
  }

  private class ClearLastDigitButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (textField.getText().length() == 0) {
        textField.setText("");
      } else {
        String content = textField.getText();
        textField.setText(content.substring(0, content.length() - 1));
      }
      dotButton.setEnabled(true);
    }
  }
}