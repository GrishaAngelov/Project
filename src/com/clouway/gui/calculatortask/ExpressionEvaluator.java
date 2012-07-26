package com.clouway.gui.calculatortask;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExpressionEvaluator {
  private final String correctExpression = "[-]?[0-9]+[\\.]?[0-9]*[+|\\-|*|/]{1}[-]?[0-9]+[\\.]?[0-9]*[[+|\\-|*|/]{1}[0-9]+[\\.]?[0-9]]*";
  private List<String> extractedDelimiters;
  private List<String> stringNumbersList;
  private List<String> numberList = new ArrayList<String>();
  private List<Double> extractedNumbers;

  public double evaluateExpression(String expression) {
    if (isCorrectExpression(expression)) {
      List<Double> extractedNumbersAsDoubles = extractNumbersFrom(expression);
      checkForNegativeFirstOperand(expression);
      return performEvaluation(extractedNumbersAsDoubles);
    } else {
      throw new IncorrectExpressionException();
    }
  }

  private boolean isCorrectExpression(String expression) {
    boolean isCorrect = false;
    Pattern pattern = Pattern.compile(correctExpression);
    Matcher matcher = pattern.matcher(expression);
    if (matcher.find()) {
      isCorrect = true;
    }
    return isCorrect;
  }

  private double performEvaluation(List<Double> extractedNumbersAsDoubles) {
    ExpressionSolver expressionSolver = new ExpressionSolver(extractedNumbersAsDoubles, extractedDelimiters);
    return expressionSolver.solve();
  }

  private List<Double> extractNumbersFrom(String expression) {
    stringNumbersList = extractNumbersAsStringsFrom(expression);
    extractedNumbers = convertStringNumbersToDoubles(stringNumbersList);
    return extractedNumbers;
  }

  private double checkForNegativeFirstOperand(String evaluationString) {
    if (evaluationString.charAt(0) == '-') {
      double number = Double.parseDouble(String.format("-%s", stringNumbersList.get(0)));
      extractedNumbers.set(0, number);
      extractedDelimiters.remove(0);
    }
    return extractedNumbers.get(0);
  }

  public List<String> extractNumbersAsStringsFrom(String evaluationString) {
    ExpressionServicesProvider servicesProvider = new ExpressionServicesProvider();

    extractedDelimiters = servicesProvider.extractDelimitersInString(evaluationString);
    String operationRegEx = servicesProvider.buildRegExFrom(extractedDelimiters);
    String[] splitNumbersAsStrings = evaluationString.split(operationRegEx);
    numberList = getSplitNumbersAsStringList(splitNumbersAsStrings);
    return numberList;
  }

  private List<String> getSplitNumbersAsStringList(String[] splitNumbersAsStrings) {

    for (int i = 0; i < splitNumbersAsStrings.length; i++) {
      if (!splitNumbersAsStrings[i].equals("")) {
        numberList.add(splitNumbersAsStrings[i]);
      }
    }
    return numberList;
  }

  private List<Double> convertStringNumbersToDoubles(List<String> splitNumbers) {
    List<Double> convertedNumbers = new ArrayList<Double>();
    for (int i = 0; i < splitNumbers.size(); i++) {
      double number = Double.parseDouble(splitNumbers.get(i));
      convertedNumbers.add(number);
    }
    return convertedNumbers;
  }
}
