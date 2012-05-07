package com.clouway.io.reverser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Reverser {

  /**
   * Method reverses the content of given file
   * @param file
   * @throws IOException
   */
  public void reverse(File file) throws IOException {

    FileReader fileReader = new FileReader(file);
    Scanner scanner = new Scanner(file);
    PrintWriter printWriter = null;
    StringBuilder stringBuilder = new StringBuilder();

    try {
      while (scanner.hasNext()) {
        stringBuilder.append(scanner.nextLine() + '\n');
      }
//    String newFilename = file.getName().substring(0,file.getName().length()-4) + "_reversed.txt";
      printWriter = new PrintWriter(file);
      printWriter.write(stringBuilder.reverse().toString());
    } finally {
      scanner.close();
      fileReader.close();
      printWriter.close();
    }
  }
}
