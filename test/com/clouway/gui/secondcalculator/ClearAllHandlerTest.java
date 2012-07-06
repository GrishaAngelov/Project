package com.clouway.gui.secondcalculator;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClearAllHandlerTest {

  //    JTextField textField = new JTextField();
//    TextFieldWrapper wrapper = new TextFieldWrapper(textField);
//
//    ClearAllHandler handler = new ClearAllHandler(new ActionListenerWrapper() {
//      @Override
//      public void actionPerformed(HasText hasText) {
//
//      }
//    }, wrapper);

  class MockHasText implements HasText {
    public LinkedList<String> stack = new LinkedList<String>();

    @Override
    public String getTextValue() {
      return stack.pop();
    }

    @Override
    public void setTextValue(String text) {
      stack.push(text);
    }

    public void pretendHasStackValues(String... args) {
      for (String arg : args) {
        stack.add(arg);
      }
    }
  }

  class OperationActionListener implements ActionListenerWrapper {

    private List<String> operationStack;
    private MathCalculator mathCalculator;

    public OperationActionListener(List<String> operationStack, MathCalculator mathCalculator) {
      this.operationStack = operationStack;
      this.mathCalculator = mathCalculator;
    }

    @Override
    public void actionPerformed(HasText hasText) {

      String operation = hasText.getTextValue();
      if (mathCalculator.isCalculationOperation(operation)) {
        int result = mathCalculator.calculate(operationStack);
        hasText.setTextValue("" + result);
      } else {
        operationStack.add(operation);
      }


    }
  }

  class MockMathCalculator implements MathCalculator {

    private static final String CALCULATION_OPERATION_NAME = "=";
    public List<String> operationStack;
    public int returnValue = 0;

    @Override
    public boolean isCalculationOperation(String operationName) {
      return CALCULATION_OPERATION_NAME.equals(operationName);
    }

    @Override
    public int calculate(List<String> operationStack) {
      this.operationStack = operationStack;
      return returnValue;
    }
  }



  @Test
  public void textValueIsAddedFromProvidedHasText() throws Exception {

    MockHasText textField = new MockHasText();
    List<String> operationStack = new LinkedList<String>();

    OperationActionListener listener = new OperationActionListener(operationStack, new MockMathCalculator());
    textField.setTextValue("9");

    listener.actionPerformed(textField);

    assertThat(operationStack.size(),is(equalTo(1)));
    assertThat(operationStack.get(0),is(equalTo("9")));
  }

  @Test
  public void operationsCouldBeAddedToTheStack() throws Exception {

    MockHasText textField = new MockHasText();
    MockMathCalculator mathCalculator = new MockMathCalculator();

    List<String> operationStack = new LinkedList<String>();

    textField.pretendHasStackValues("9","+","5","=");
    OperationActionListener listener = new OperationActionListener(operationStack, mathCalculator);

    mathCalculator.returnValue = 14;

    // 9 button click
    listener.actionPerformed(textField);

    // + button click
    listener.actionPerformed(textField);

    //
    listener.actionPerformed(textField);

    listener.actionPerformed(textField);

    assertThat(operationStack.size(),is(equalTo(3)));
    assertThat(operationStack.get(0),is(equalTo("9")));
    assertThat(operationStack.get(1),is(equalTo("+")));
    assertThat(operationStack.get(2),is(equalTo("5")));

    assertThat(mathCalculator.operationStack,is(sameInstance(operationStack)));
    assertThat(textField.stack.pop(),is(equalTo("14")));
  }

  @Test
  public void calculationOperationsShouldNotBeNeighbour() throws Exception {

  }
}
