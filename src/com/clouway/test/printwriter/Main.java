package com.clouway.test.printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    File file = new File("sample.txt");
    PrintWriter printWriter = null;
    try {
      printWriter = new PrintWriter(file);
      for (int i = 0; i < 10; i++) {
       printWriter.println("Hello!");
      }
    } catch (FileNotFoundException ex) {
      System.err.printf("File %s is not found!\n", file);
    }
    finally {
      printWriter.close();
    }
  }
}
