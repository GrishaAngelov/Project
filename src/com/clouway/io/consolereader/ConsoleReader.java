package com.clouway.io.consolereader;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.util.Scanner;

public class ConsoleReader {
  /**
   * ConsoleReader class provides methods for reading various types of input data - string, int, char, float
   */

  Scanner scanner = new Scanner(System.in);

  /**
   * Method returns an string data entered by the user
   * @return  string data entered by the user
   */
  public String readString() {
    return scanner.nextLine();
  }

  /**
   * Method returns an integer data entered by the user
   * @return  integer data entered by the user
   */
  public int readInt() {
    return scanner.nextInt();
  }

  /**
   * Method returns an character data entered by the user
   * @return  character data entered by the user
   */
  public char readChar() {
    return scanner.next().charAt(0);
  }

  /**
   * Method returns an float data entered by the user
   * @return  float data entered by the user
   */
  public float readFloat() {
    return scanner.nextFloat();
  }
}