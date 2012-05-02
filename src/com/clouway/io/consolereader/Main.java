package com.clouway.io.consolereader;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;

/**
 * @author user
 */
public class Main {
  public static void main(String[] args) throws IOException {
    ConsoleReader consoleReader = new ConsoleReader();

    System.out.print("Enter string: ");
    System.out.println("string: " + consoleReader.readString());

    System.out.print("Enter int: ");
    System.out.println("int: " + consoleReader.readInt());

    System.out.print("Enter char: ");
    System.out.println("char: " + consoleReader.readChar());

    System.out.print("Enter float: ");
    System.out.println("float: " + consoleReader.readFloat());
  }
}
