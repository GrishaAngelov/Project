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
  private String[] splitNumbersAsStrings;
  private double result;

  public double evaluateExpression(String expression) {
    String[] extractedNumbersAsStrings = extractNumbersFrom(expression);
    List<Double> extractedNumbersAsDoubles = convertStringNumbersToDoubles(extractedNumbersAsStrings);
    operandsAndOperationProvider.setFirstNumber(extractedNumbersAsDoubles.get(0));

    for (int i = 0; i < extractedNumbersAsDoubles.size() - 1; i++) {
     Operation operation = operationHashtable.get(extractedDelimiters.get(i));
      operandsAndOperationProvider.setSecondNumber(extractedNumbersAsDoubles.get(i + 1));
      result = operation.calculate(operandsAndOperationProvider.getFirstNumber(), operandsAndOperationProvider.getSecondNumber());
      operandsAndOperationProvider.setFirstNumber(result);
    }
    return result;
  }

  public String[] extractNumbersFrom(String evaluationString) {
    extractedDelimiters = servicesProvider.extractDelimitersInString(evaluationString);
    String operationRegEx = servicesProvider.buildRegExFrom(extractedDelimiters);
    splitNumbersAsStrings = evaluationString.split(operationRegEx);
    checkForCorrectionOfSplitAsStringsNumbers();
    checkForNegativeFirstOperand(evaluationString);
    return splitNumbersAsStrings;
  }

  private void checkForNegativeFirstOperand(String evaluationString) {
    if (evaluationString.charAt(0) == '-') {
      makeFirstOperandNegative();
      extractedDelimiters.remove(0);
    }
  }

  private void checkForCorrectionOfSplitAsStringsNumbers() {
    if (splitNumbersAsStrings[0].equals("")) {
      splitNumbersAsStrings = correctSplitNumbers(splitNumbersAsStrings);
    }
  }

  private String[] correctSplitNumbers(String[]splitNumbersAsStrings) {
    String[] correctNumbers = new String[splitNumbersAsStrings.length - 1];
    for (int i = 0; i < correctNumbers.length; i++) {
      correctNumbers[i] = splitNumbersAsStrings[i + 1];
    }
    return correctNumbers;
  }

  private String makeFirstOperandNegative() {
    return splitNumbersAsStrings[0] = String.format("-%s", splitNumbersAsStrings[0]);
  }

  public List<Double> convertStringNumbersToDoubles(String[]splitNumbers) {
    List<Double> convertedNumbers = new ArrayList<Double>();
    for (int i = 0; i < splitNumbers.length; i++) {
      convertedNumbers.add(Double.parseDouble(splitNumbers[i]));
    }
    return convertedNumbers;
  }

}
