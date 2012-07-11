package com.clouway.gui.thirdcalculator;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EqualsHandler implements ActionListener {
  private CalculatorTextField textField;
  private Operator tableOperator;
  private Hashtable<String, Operation> operationHashtable;
  private OperandsAndOperationProvider operandsAndOperationProvider;

  public EqualsHandler(CalculatorTextField textField, Operator tableOperator, OperandsAndOperationProvider operandsAndOperationProvider) {
    this.textField = textField;
    this.tableOperator = tableOperator;
    this.operandsAndOperationProvider = operandsAndOperationProvider;
  }

  public void actionPerformed(ActionEvent event) {
    if (textField.getFieldText().length() == 0) {
      textField.setFieldText("");
    } else {
      try {
        operandsAndOperationProvider.setSecondNumber(Double.parseDouble(textField.getFieldText()));
        if (operandsAndOperationProvider.getSecondNumber() == 0.0) {
          throw new ArithmeticException();
        }
        operationHashtable = tableOperator.fill();
        Operation operation = operationHashtable.get(operandsAndOperationProvider.getOperation());
        textField.setFieldText(operation.calculate(operandsAndOperationProvider.getFirstNumber(), operandsAndOperationProvider.getSecondNumber()).toString());
      } catch (ArithmeticException e) {
        textField.setFieldText("Undefined Operation");
      }
    }
  }
}
