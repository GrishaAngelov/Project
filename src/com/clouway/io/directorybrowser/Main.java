package com.clouway.io.directorybrowser;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    DirectoryBrowser directoryBrowser = new DirectoryBrowser();
    directoryBrowser.listContent("/home/clouway/MyStuff/");
  }
}
