package com.clouway.io.textwriter;

import java.io.*;
import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TextWriter {

  /**
   * Method writes user input to file
   *
   * @param file
   * @throws IOException
   */
  public void writeToFile(File file) throws IOException {

    Scanner scanner = new Scanner(System.in);

//    if (!file.exists()) {
//      file.createNewFile();
//    }

    PrintWriter writer = new PrintWriter(file);
    String data = "";
    try {
      while (!data.equals(".")) {
        System.out.print("Enter text: ");
        data = scanner.nextLine();
        if (!data.equals(".")) {
          writer.write(data + "\n");
        }
      }

    } finally {
      writer.close();
      scanner.close();
    }
  }
}