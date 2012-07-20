package com.clouway.gui.calculatortask;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExpressionEvaluator {
  private ExpressionServicesProvider servicesProvider = new ExpressionServicesProvider();
  private OperandsAndOperationProvider operandsAndOperationProvider = new OperandsAndOperationProvider();
  private Operator tableOperator = new Operator();
  private Hashtable<String, Operation> operationHashtable = tableOperator.fill();
  private List<String> extractedDelimiters;
  private String[] splittedNumbersAsStrings;
  private double result;

  public double evaluateExpression(String expression) {
    String[] extractedNumbersAsStrings = extractNumbersFrom(expression);
    List<Integer> extractedNumbersAsIntegers = convertStringNumbersToIntegers(extractedNumbersAsStrings);
    operandsAndOperationProvider.setFirstNumber(extractedNumbersAsIntegers.get(0));

    for (int i = 0; i < extractedNumbersAsIntegers.size() - 1; i++) {
     Operation operation = operationHashtable.get(extractedDelimiters.get(i));
      operandsAndOperationProvider.setSecondNumber(extractedNumbersAsIntegers.get(i + 1));
      result = operation.calculate(operandsAndOperationProvider.getFirstNumber(), operandsAndOperationProvider.getSecondNumber());
      operandsAndOperationProvider.setFirstNumber(result);
    }
    return result;
  }

  public String[] extractNumbersFrom(String evaluationString) {
    extractedDelimiters = servicesProvider.extractDelimitersInString(evaluationString);
    String operationRegEx = servicesProvider.buildRegExFrom(extractedDelimiters);
    splittedNumbersAsStrings = evaluationString.split(operationRegEx);
    checkForCorrectionOfSplittedAsStringsNumbers();
    checkForNegativeFirstOperand(evaluationString);
    return splittedNumbersAsStrings;
  }

  private void checkForNegativeFirstOperand(String evaluationString) {
    if (evaluationString.charAt(0) == '-') {
      makeFirstOperandNegative();
      extractedDelimiters.remove(0);
    }
  }

  private void checkForCorrectionOfSplittedAsStringsNumbers() {
    if (splittedNumbersAsStrings[0].equals("")) {
      splittedNumbersAsStrings = correctSplittedNumbers(splittedNumbersAsStrings);
    }
  }

  private String[] correctSplittedNumbers(String[] splittedNumbersAsStrings) {
    String[] correctNumbers = new String[splittedNumbersAsStrings.length - 1];
    for (int i = 0; i < correctNumbers.length; i++) {
      correctNumbers[i] = splittedNumbersAsStrings[i + 1];
    }
    return correctNumbers;
  }

  private String makeFirstOperandNegative() {
    return splittedNumbersAsStrings[0] = String.format("-%s", splittedNumbersAsStrings[0]);
  }

  public List<Integer> convertStringNumbersToIntegers(String[] splittedNumbers) {
    List<Integer> convertedNumbers = new ArrayList<Integer>();
    for (int i = 0; i < splittedNumbers.length; i++) {
      convertedNumbers.add(Integer.parseInt(splittedNumbers[i]));
    }
    return convertedNumbers;
  }

}
