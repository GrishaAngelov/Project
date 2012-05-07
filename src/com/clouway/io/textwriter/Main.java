package com.clouway.io.textwriter;

import java.io.File;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    try {

      TextWriter textWriter = new TextWriter();
      File myFile = new File("text.txt");
      textWriter.writeToFile(myFile);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}

