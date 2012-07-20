package com.clouway.gui.calculatortask;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Complex {

  public static String extractExpression(String expression) {
    int openBracketIndex = expression.lastIndexOf("(")+1;
    int closeBracketIndex = findMatchCloseBracket(openBracketIndex, expression);
    return expression.substring(openBracketIndex, closeBracketIndex);
  }

  public static int findMatchCloseBracket(int openBracketIndex, String expression) {
    int closeBracketIndex = openBracketIndex;
    while (expression.charAt(closeBracketIndex) != ')') {
      closeBracketIndex++;
    }
    return closeBracketIndex;
  }
  public static int findOpenBracket(int openBracketIndex, String expression) {
    int closeBracketIndex = openBracketIndex;
    while (expression.charAt(closeBracketIndex) != ')') {
      closeBracketIndex++;
    }
    return closeBracketIndex;
  }

//  public static String findPairBrackets(String expression){
//
//  }

  public static void main(String[] args) {
    String expression = "2+5*(2+(4-2)+(2+3))"; // 4 18
//    String extracted = extractExpression(expression);
//    System.out.println(extracted);
    int openBracketIndex = expression.indexOf("(");
    int closeBracketIndex = expression.lastIndexOf(")");
    System.out.println(openBracketIndex+" "+closeBracketIndex);
  }
}
