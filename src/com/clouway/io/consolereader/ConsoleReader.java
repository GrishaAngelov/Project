package com.clouway.io.consolereader;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.util.Scanner;

public class ConsoleReader {

  Scanner scanner = new Scanner(System.in);

  public String readString() {
    return scanner.nextLine();
  }

  public int readInt() {
    return scanner.nextInt();
  }

  public char readChar() {
    return scanner.next().charAt(0);
  }

  public float readFloat() {
    return scanner.nextFloat();
  }
}