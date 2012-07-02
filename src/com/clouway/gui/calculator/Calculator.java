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
  private int firstIntegerNumber = 0;
  private int secondIntegerNumber = 0;
  private String character;
  private Hashtable<String, Number> table = new Hashtable<String, Number>();
  private JPanel textPanel = new JPanel();
  private JPanel numberPanel = new JPanel();
  private JPanel operationPanel = new JPanel();
  private boolean isDouble = false;
  private double firstDoubleNumber;
  private double secondDoubleNumber;

  public void setTheLayout() {
    layout = new GridLayout();
    container = getContentPane();
    container.setLayout(layout);
    textPanel.setBackground(Color.ORANGE);
    numberPanel.setBackground(Color.ORANGE);
    operationPanel.setBackground(Color.ORANGE);
  }

  public void createButtons() {
    clearButton = new JButton("clr");
    equalsButton = new JButton("=");
    dotButton = new JButton(".");
    clearLastDigitButton = new JButton("<-");
  }

  public void setTextField() {
    textField = new JTextField();
    textField.setEditable(false);
    textField.setColumns(20);
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    textField.setFont(new Font("Times",Font.BOLD,12));
  }

  public void createHandlers() {
    String[] buttonLabel = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    List<ButtonHandler> buttonHandlerList = new ArrayList<ButtonHandler>();
    textPanel.add(textField);
    add(textPanel);
    numberPanel.setLayout(new GridLayout(4, 3, 5, 5));
    for (int i = 0; i < buttonLabel.length; i++) {

      ButtonHandler buttonHandler = new ButtonHandler(buttonLabel[i]);
      buttonHandlerList.add(buttonHandler);

      JButton button = new JButton(buttonLabel[i]);
      button.addActionListener(buttonHandler);
      numberPanel.add(button);
    }
    textPanel.add(numberPanel, BorderLayout.WEST);

    String[] operationButtonLabel = {"+", "-", "*", "/"};
    List<OperatorHandler> operatorHandlerList = new ArrayList<OperatorHandler>();
    operationPanel.setLayout(new GridLayout(4, 3, 5, 5));
    operationPanel.add(clearLastDigitButton);
    operationPanel.add(clearButton);
    for (int i = 0; i < operationButtonLabel.length; i++) {
      OperatorHandler operatorHandler = new OperatorHandler(operationButtonLabel[i]);
      operatorHandlerList.add(operatorHandler);

      JButton operationButton = new JButton(operationButtonLabel[i]);
      operationPanel.add(operationButton);
      operationButton.addActionListener(operatorHandler);
    }

    operationPanel.add(dotButton);
    operationPanel.add(equalsButton);
    textPanel.add(operationPanel, BorderLayout.EAST);

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
    if (!isDouble) {
      table.put("+", operator.add(firstIntegerNumber, secondIntegerNumber));
      table.put("-", operator.sub(firstIntegerNumber, secondIntegerNumber));
      table.put("*", operator.mul(firstIntegerNumber, secondIntegerNumber));
      table.put("/", operator.div(firstIntegerNumber, secondIntegerNumber));
    } else {
      table.put("+", operator.add(firstDoubleNumber, secondDoubleNumber));
      table.put("-", operator.sub(firstDoubleNumber, secondDoubleNumber));
      table.put("*", operator.mul(firstDoubleNumber, secondDoubleNumber));
      table.put("/", operator.div(firstDoubleNumber, secondDoubleNumber));
    }
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
      if (!isDouble) {
        firstIntegerNumber = Integer.parseInt(textField.getText());
      } else {
        firstDoubleNumber = Double.parseDouble(textField.getText());
      }
      textField.setText("");
      character = operationCharacter;
      dotButton.setEnabled(true);
    }
  }

  private class ClearButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      textField.setText("");
      firstIntegerNumber = 0;
      secondIntegerNumber = 0;
    }
  }

  private class EqualsButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      try {
        if (!isDouble) {
          secondIntegerNumber = Integer.parseInt(textField.getText());
        } else {
          secondDoubleNumber = Double.parseDouble(textField.getText());
        }
        setTableContent();
        textField.setText(table.get(character).toString());
        dotButton.setEnabled(true);
        if(secondIntegerNumber == 0 && secondDoubleNumber == 0.0){
          throw new ArithmeticException();
        }
      } catch (ArithmeticException e) {
        textField.setText("Undefined Operation");
      }
    }
  }

  private class DotButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      textField.setText(textField.getText() + ".");
      dotButton.setEnabled(false);
      isDouble = true;
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