package com.clouway.gui.calculatortask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EqualsButtonListener implements ActionListener {
  private HasText text;

  public EqualsButtonListener(HasText text) {
    this.text = text;
  }

  public void actionPerformed(ActionEvent event) {
    if (text.getFieldText().length() == 0) {
      text.setFieldText("");
    } else {
      try {
        String expression = text.getFieldText();
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        Double result = expressionEvaluator.evaluateExpression(expression);
        text.setFieldText(result.toString());
      } catch (DivideByZeroException e) {
        text.setFieldText("Undefined Operation");
      } catch (IncorrectExpressionException e) {
        text.setFieldText("Incorrect Expression");
      } catch (NumberFormatException e) {
        text.setFieldText(e.toString());
      }
    }
  }
}