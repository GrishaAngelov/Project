package com.clouway.objectsinjava.sumator;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {

    Sumator sumator = new Sumator();

    System.out.println("Integer: " + sumator.sum(5, 4));
    System.out.println("Double: " + sumator.sum(2.25, 1.25));
    System.out.println("String: " + sumator.sum("5", "2"));

    BigInteger firstBigIntegerNum = new BigInteger("2000000000000000000");
    BigInteger secondBigIntegerNum = new BigInteger("1000000000000000000");
    System.out.println("BigInteger: " + sumator.sum(firstBigIntegerNum, secondBigIntegerNum));

    BigDecimal firstBigDecimalNum = new BigDecimal("2.99999999999999999999");
    BigDecimal secondBigDecimalNum = new BigDecimal("7.00000000000000000001");
    System.out.println("BigDecimal: " + sumator.sum(firstBigDecimalNum, secondBigDecimalNum));
  }
}