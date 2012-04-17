package com.clouway.objectsinjava.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 *         Class Sumator provide metods for calculating sum of two numbers
 */
public class Sumator {

  /**
   * Calculates sum of two numbers, type Integer
   *
   * @param firstNumber
   * @param secondNumber
   * @return sum of Integer numbers
   */
  public int sum(Integer firstNumber, Integer secondNumber) {

    return firstNumber + secondNumber;
  }

  /**
   * Calculates sum of two numbers, type Double
   *
   * @param firstNumber
   * @param secondNumber
   * @return sum of Double numbers
   */
  public double sum(Double firstNumber, Double secondNumber) {
    return firstNumber + secondNumber;
  }

  /**
   * Calculates sum of two numbers, type String
   *
   * @param firstNumber
   * @param secondNumber
   * @return sum of String numbers
   */
  public String sum(String firstNumber, String secondNumber) {
    Double sum = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
    return sum.toString();
  }

  /**
   * Calculates sum of two numbers, type BigInteger
   *
   * @param firstNumber
   * @param secondNumber
   * @return sum of BigInteger numbers
   */
  public BigInteger sum(BigInteger firstNumber, BigInteger secondNumber) {

    return firstNumber.add(secondNumber);
  }

  /**
   * Calculates sum of two numbers, type BigDecimal
   *
   * @param firstNumber
   * @param secondNumber
   * @return sum of BigDecimal numbers
   */
  public BigDecimal sum(BigDecimal firstNumber, BigDecimal secondNumber) {

    return firstNumber.add(secondNumber);
  }
}