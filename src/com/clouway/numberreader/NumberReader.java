package com.clouway.numberreader;

import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class NumberReader {
  public int readNumber() {
    Scanner scanner = new Scanner(System.in);
    int num = Integer.parseInt(scanner.nextLine());
    if (num < 0 || num > 100) {
      throw new NumberInputOutOfRange();
    }
    return num;
  }
}
