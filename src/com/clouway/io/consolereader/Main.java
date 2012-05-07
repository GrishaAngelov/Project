package com.clouway.io.consolereader;

/**
* @author Grisha Angelov <grisha.angelov@clouway.com>
*/

import java.io.IOException;
import java.util.InputMismatchException;

/**
* @author user
*/
public class Main {
  public static void main(String[] args) throws IOException {

    ConsoleReader consoleReader = new ConsoleReader();

    System.out.print("Enter string: ");
    System.out.println("string: " + consoleReader.readString());

    System.out.print("Enter int: ");
    try {
      System.out.println("int: " + consoleReader.readInt());
    } catch (InputMismatchException ime) {
      System.out.print("Incorrect input! Enter only integer numbers!");
      return;
    }

    System.out.print("Enter char: ");
    System.out.println("char: " + consoleReader.readChar());

    System.out.print("Enter float: ");
    try {
      System.out.println("float: " + consoleReader.readFloat());
    } catch (InputMismatchException ime) {
      System.out.print("Incorrect input! Enter only numbers!");
      return;
    }
  }
}
