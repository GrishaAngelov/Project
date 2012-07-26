package com.clouway.gui.calculatortask;

import java.util.Hashtable;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExpressionSolver {

  private List<Double> extractedNumbersAsDoubles;
  private List<String> extractedDelimiters;
  private OperandsProvider operandsProvider = new OperandsProvider();
  private int delimiterIndex;
  private String operationSymbol;
  private Operation operation;
  private Hashtable<String, Operation> operationHashtable = new Operator().fill();

  public ExpressionSolver(List<Double> extractedNumbersAsDoubles, List<String> extractedDelimiters) {
    this.extractedNumbersAsDoubles = extractedNumbersAsDoubles;
    this.extractedDelimiters = extractedDelimiters;
  }


  public Double solve() {
    while (extractedNumbersAsDoubles.size() > 1) {
      int opIndex = findIndexOfPriorityOperation(extractedDelimiters);
      operandsProvider.setFirstNumber(extractedNumbersAsDoubles.get(opIndex));
      Character operationSign = extractedDelimiters.get(opIndex).charAt(0);

      if (checkForPriority(operationSign)) {
        solveWithPriority(opIndex, operationSign);
      } else {
        solveWithoutPriority(operationSign);
      }
    }
    double result = operandsProvider.getFirstNumber();
    return result;
  }

  private void solveWithPriority(int opIndex, Character operationSign) {
    operandsProvider.setSecondNumber(extractedNumbersAsDoubles.get(opIndex + 1));
    checkForDivisionByZero(operandsProvider, operationSign);
    delimiterIndex = getDelimiterIndex(extractedDelimiters, operationSign);
    operationSymbol = extractedDelimiters.get(delimiterIndex);
    operation = operationHashtable.get(operationSymbol);
    double calculated = operation.calculate(operandsProvider.getFirstNumber(), operandsProvider.getSecondNumber());
    operandsProvider.setFirstNumber(calculated);
    extractedNumbersAsDoubles.set(opIndex, operandsProvider.getFirstNumber());
    extractedNumbersAsDoubles.remove(opIndex + 1);
    extractedDelimiters.remove(opIndex);
  }

  private void solveWithoutPriority(Character operationSign) {
    operandsProvider.setFirstNumber(extractedNumbersAsDoubles.get(0));
    operandsProvider.setSecondNumber(extractedNumbersAsDoubles.get(1));
    delimiterIndex = getDelimiterIndex(extractedDelimiters, operationSign);
    operationSymbol = extractedDelimiters.get(delimiterIndex);
    operation = operationHashtable.get(operationSymbol);
    operandsProvider.setFirstNumber(operation.calculate(operandsProvider.getFirstNumber(), operandsProvider.getSecondNumber()));
    extractedNumbersAsDoubles.set(0, operandsProvider.getFirstNumber());
    extractedNumbersAsDoubles.remove(1);
    extractedDelimiters.remove(0);
  }

  private void checkForDivisionByZero(OperandsProvider operandsProvider, Character operationSign) {
    if (operandsProvider.getSecondNumber() == 0.0 && operationSign == '/') {
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

  private int getDelimiterIndex(List<String> delimiters, Character ch) {
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
