package com.clouway.gui.calculatortask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    ExpressionEvaluator evaluator = new ExpressionEvaluator();
    List<String> delimiters = new ArrayList<String>();
    delimiters.add("+");
    delimiters.add("-");
    evaluator.evaluateExpression("2*-3");
  }
}
