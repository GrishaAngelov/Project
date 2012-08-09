package com.clouway.gui.calculatortask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EqualsListener implements ActionListener {
  private CalculatorTextField textField;

  public EqualsListener(CalculatorTextField textField) {
    this.textField = textField;
  }

  public void actionPerformed(ActionEvent event) {
    if (textField.getFieldText().length() == 0) {
      textField.setFieldText("");
    } else {
      try {
        String expression = textField.getFieldText();
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        Double result = expressionEvaluator.evaluateExpression(expression);
        textField.setFieldText(result.toString());
      } catch (DivideByZeroException e) {
        textField.setFieldText("Undefined Operation");
      } catch (IncorrectExpressionException e) {
        textField.setFieldText("Incorrect Expression");
      } catch (NumberFormatException e) {
        textField.setFieldText(e.toString());
      }
    }
  }
}