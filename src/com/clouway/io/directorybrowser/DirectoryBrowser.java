package com.clouway.io.directorybrowser;

import java.io.File;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DirectoryBrowser {

  /**
   * Method determines whether given path leads to a file or folder.
   * In second case it print the content of the folder.
   * @param path - path to file or folder
   */

  public void listContent(String path) {
//    String filename =  path.substring(path.lastIndexOf("/")+1);
    File myFile = new File(path);
    if (myFile.isFile()) {
      System.out.println("This is a file.");
    } else {
      String[] dir = myFile.list();
      System.out.println("This is a directory. Content:");
      for (String item : dir) {
        System.out.println(item);
      }
    }
  }
}
