package com.clouway.gui.calculatortask;

import java.util.Hashtable;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExpressionSolver {

  private List<Double> numbersAsDoubles;
  private List<String> operationDelimiters;
  private CalculationOperandsProvider calculationOperandsProvider = new CalculationOperandsProvider();
  private int delimiterIndex;
  private String operationSymbol;
  private Operation operation;
  private Hashtable<String, Operation> operationHashtable = new Operator().fill();

  public ExpressionSolver(List<Double> numbersAsDoubles, List<String> operationDelimiters) {
    this.numbersAsDoubles = numbersAsDoubles;
    this.operationDelimiters = operationDelimiters;
  }


  public Double solve() {
    while (numbersAsDoubles.size() > 1) {
      int opIndex = findIndexOfPriorityOperation(operationDelimiters);
      calculationOperandsProvider.setFirstOperand(numbersAsDoubles.get(opIndex));
      Character operationSign = operationDelimiters.get(opIndex).charAt(0);

      if (checkForPriority(operationSign)) {
        solveWithPriority(opIndex, operationSign);
      } else {
        solveWithoutPriority(operationSign);
      }
    }
    double result = calculationOperandsProvider.getFirstOperand();
    return result;
  }

  /* example: 5+8/4
      1 step: 8/4 = 2
      2 step: 5+2 = 7
   */
  private void solveWithPriority(int opIndex, Character operationSign) {
    calculationOperandsProvider.setSecondOperand(numbersAsDoubles.get(opIndex + 1));
    checkForDivisionByZero(calculationOperandsProvider, operationSign);
    delimiterIndex = getOperationDelimiterIndex(operationDelimiters, operationSign);
    operationSymbol = operationDelimiters.get(delimiterIndex);
    operation = operationHashtable.get(operationSymbol);
    double calculated = operation.calculate(calculationOperandsProvider.getFirstOperand(), calculationOperandsProvider.getSecondOperand());
    calculationOperandsProvider.setFirstOperand(calculated);
    numbersAsDoubles.set(opIndex, calculationOperandsProvider.getFirstOperand());
    numbersAsDoubles.remove(opIndex + 1);
    operationDelimiters.remove(opIndex);
  }

  /* example: 5+8-4
      1 step: 5+8 = 13
      2 step: 13-4 = 9
   */
  private void solveWithoutPriority(Character operationSign) {
    calculationOperandsProvider.setFirstOperand(numbersAsDoubles.get(0));
    calculationOperandsProvider.setSecondOperand(numbersAsDoubles.get(1));
    delimiterIndex = getOperationDelimiterIndex(operationDelimiters, operationSign);
    operationSymbol = operationDelimiters.get(delimiterIndex);
    operation = operationHashtable.get(operationSymbol);
    calculationOperandsProvider.setFirstOperand(operation.calculate(calculationOperandsProvider.getFirstOperand(), calculationOperandsProvider.getSecondOperand()));
    numbersAsDoubles.set(0, calculationOperandsProvider.getFirstOperand());
    numbersAsDoubles.remove(1);
    operationDelimiters.remove(0);
  }

  private void checkForDivisionByZero(CalculationOperandsProvider calculationOperandsProvider, Character operationSign) {
    if (calculationOperandsProvider.getSecondOperand() == 0.0 && operationSign == '/') {
      throw new DivideByZeroException();
    }
  }

  private boolean checkForPriority(Character operationSign) {
    boolean hasPriority;
    if (operationSign == '*' || operationSign == '/') {
      hasPriority = true;
    } else {
      hasPriority = false;
    }
    return hasPriority;
  }

  private int getOperationDelimiterIndex(List<String> delimiters, Character ch) {
    int index = 0;
    for (int i = 0; i < delimiters.size(); i++) {
      if (delimiters.get(i).equals(ch.toString())) {
        index = i;
        break;
      }
    }
    return index;
  }

  private int findIndexOfPriorityOperation(List<String> operations) {
    int index = 0;
    for (int i = index; i < operations.size(); i++) {
      if (operations.get(i).equals("*") || operations.get(i).equals("/")) {
        index = i;
        break;
      }
    }
    return index;
  }
}
