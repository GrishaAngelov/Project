package com.clouway.gui.secondcalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EqualsHandler implements ActionListener {
  private JTextField textField;
  private Operator operator;
  private Hashtable<String, Operation> hashtable;
  private NumbersHolder numbersHolder;

  public EqualsHandler(JTextField textField, Operator operator, NumbersHolder numbersHolder) {
    this.textField = textField;
    this.operator = operator;
    this.numbersHolder = numbersHolder;
  }

  public void actionPerformed(ActionEvent event) {
    if (textField.getText().length() == 0) {
      textField.setText("");
    } else {
      try {
        numbersHolder.setSecondNum(Double.parseDouble(textField.getText()));
        if (numbersHolder.getSecondNum() == 0.0) {
          throw new ArithmeticException();
        }
        hashtable = operator.fill();
        Operation operation = hashtable.get(numbersHolder.getOperation());
        textField.setText(operation.calculate(numbersHolder.getFirstNum(), numbersHolder.getSecondNum()).toString());
      } catch (ArithmeticException e) {
        textField.setText("Undefined Operation");
      }
    }
  }
}
