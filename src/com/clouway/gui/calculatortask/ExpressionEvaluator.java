package com.clouway.gui.calculatortask;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExpressionEvaluator {
  private ExpressionServicesProvider servicesProvider = new ExpressionServicesProvider();
  private OperandsProvider operandsProvider = new OperandsProvider();
  private Operator tableOperator = new Operator();
  private Hashtable<String, Operation> operationHashtable = tableOperator.fill();
  private List<String> extractedDelimiters;
  private String[] splitNumbersAsStrings;
  private List<Double> extractedNumbersAsDoubles;
  private String[] extractedNumbersAsStrings;
  private Operation operation;
  private double result;
  private Character operationSign;
  private int delimiterIndex;
  private String operationSymbol;


  public double evaluateExpression(String expression) {
    if (isCorrectExpression(expression)) {
      extractNumbersFrom(expression);
      checkForNegativeFirstOperand(expression);
      return performEvaluation(extractedNumbersAsDoubles);
    } else {
      throw new IncorrectExpressionException();
    }
  }

  private boolean isCorrectExpression(String expression) {
    boolean isCorrect = false;
    String correctExpression = "[-]?[0-9]+[\\.]?[0-9]*[+|\\-|*|/]{1}[0-9]+[\\.]?[0-9]*[[+|\\-|*|/]{1}[0-9]+[\\.]?[0-9]]*";

    Pattern pattern = Pattern.compile(correctExpression);
    Matcher matcher = pattern.matcher(expression);
    if (matcher.find()) {
      isCorrect = true;
    }
    return isCorrect;
  }

  private double performEvaluation(List<Double> extractedNumbersAsDoubles) {
    while (extractedNumbersAsDoubles.size() > 1) {
      int opIndex = findIndexOfPriorityOperation(extractedDelimiters);
      operandsProvider.setFirstNumber(extractedNumbersAsDoubles.get(opIndex));
      operationSign = extractedDelimiters.get(opIndex).charAt(0);

      if (checkForPriority(operationSign)) {
        operandsProvider.setSecondNumber(extractedNumbersAsDoubles.get(opIndex + 1));
        checkForDivisionByZero();
        delimiterIndex = getDelimiterIndex(extractedDelimiters, operationSign);
        operationSymbol = extractedDelimiters.get(delimiterIndex);
        operation = operationHashtable.get(operationSymbol);
        double calculated = operation.calculate(operandsProvider.getFirstNumber(), operandsProvider.getSecondNumber());
        operandsProvider.setFirstNumber(calculated);
        extractedNumbersAsDoubles.set(opIndex, operandsProvider.getFirstNumber());
        extractedNumbersAsDoubles.remove(opIndex + 1);
        extractedDelimiters.remove(opIndex);
      } else {
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
    }
    result = operandsProvider.getFirstNumber();
    return result;
  }

  private void checkForDivisionByZero() {
    if (operandsProvider.getSecondNumber() == 0.0 && operationSign == '/') {
      throw new DivideByZeroException();
    }
  }

  private void extractNumbersFrom(String expression) {
    extractedNumbersAsStrings = extractNumbersAsStringsFrom(expression);
    extractedNumbersAsDoubles = convertStringNumbersToDoubles(extractedNumbersAsStrings);
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

  private void checkForNegativeFirstOperand(String evaluationString) {
    if (evaluationString.charAt(0) == '-') {
      makeFirstOperandNegative();
      extractedDelimiters.remove(0);
    }
  }

  private double makeFirstOperandNegative() {
    double number = Double.parseDouble(String.format("-%s", extractedNumbersAsStrings[0]));
    extractedNumbersAsDoubles.set(0, number);
    return extractedNumbersAsDoubles.get(0);
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

  public String[] extractNumbersAsStringsFrom(String evaluationString) {
    extractedDelimiters = servicesProvider.extractDelimitersInString(evaluationString);
    String operationRegEx = servicesProvider.buildRegExFrom(extractedDelimiters);
    splitNumbersAsStrings = evaluationString.split(operationRegEx);
    checkForCorrectionOfSplitAsStringsNumbers();
    return splitNumbersAsStrings;
  }


  private void checkForCorrectionOfSplitAsStringsNumbers() {
    if (splitNumbersAsStrings[0].equals("")) {
      splitNumbersAsStrings = correctSplitNumbers(splitNumbersAsStrings);
    }
  }

  private String[] correctSplitNumbers(String[] splitNumbersAsStrings) {
    String[] correctNumbers = new String[splitNumbersAsStrings.length - 1];
    for (int i = 0; i < correctNumbers.length; i++) {
      correctNumbers[i] = splitNumbersAsStrings[i + 1];
    }
    return correctNumbers;
  }


  private List<Double> convertStringNumbersToDoubles(String[] splitNumbers) {
    List<Double> convertedNumbers = new ArrayList<Double>();
    for (int i = 0; i < splitNumbers.length; i++) {
      double number = Double.parseDouble(splitNumbers[i]);
      convertedNumbers.add(number);
    }
    return convertedNumbers;
  }

}
