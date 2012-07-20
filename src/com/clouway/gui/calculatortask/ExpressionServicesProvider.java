package com.clouway.gui.calculatortask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExpressionServicesProvider {
  public List<String> extractDelimitersInString(String evaluationString) {
    List<String> delimiters = new ArrayList<String>();

    checkForOperationCharacter(evaluationString, delimiters);

    for (int i = 1; i < evaluationString.length(); i++) {
      if (shouldAddDelimiter(evaluationString, delimiters, i)) {
        delimiters.add((evaluationString.substring(i, i + 1)));
      }
    }
    return delimiters;
  }

  private boolean shouldAddDelimiter(String evaluationString, List<String> delimiters, int i) {
    return checkIsOperationChar(evaluationString.charAt(i)) && (!delimiters.contains(evaluationString.charAt(i)));
  }

  private void checkForOperationCharacter(String evaluationString, List<String> delimiters) {
    if (checkIsOperationChar(evaluationString.charAt(0))) {
      delimiters.add((evaluationString.substring(0, 1)));
    }
  }

  private boolean checkIsOperationChar(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
  }

  public String buildRegExFrom(List<String> extractedDelimiters) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < extractedDelimiters.size(); i++) {
      builder.append(extractedDelimiters.get(i));
    }
    return String.format("[%s]", builder.toString());
  }
}
