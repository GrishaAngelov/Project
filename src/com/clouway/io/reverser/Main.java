package com.clouway.io.reverser;

import java.io.File;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args)  {
    File myFile = new File("file.txt");
    Reverser reverser = new Reverser();
    try{
    reverser.reverse(myFile);
    }catch (IOException ex){
      ex.printStackTrace();
    }
  }
}
