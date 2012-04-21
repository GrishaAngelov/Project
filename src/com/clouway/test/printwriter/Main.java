package com.clouway.test.printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) throws IOException {
    File file = new File("sample.txt");
    PrintWriter printWriter = null;
    try {
      printWriter = new PrintWriter(file);
      for (int i = 0; i < 10; i++) {
        printWriter.println("Hello!");
      }
    } catch (FileNotFoundException ex) {
      System.err.printf("File %s is not found!\n", file);
    } finally {
      printWriter.close();
    }

//    Scanner scanner = null;
//    try {
//      scanner = new Scanner(file);
//      while (scanner.hasNext()){
//        System.out.println(scanner.nextLine());
//      }
//    } catch (FileNotFoundException ex) {
//      System.err.printf("File %s is not found!\n", file);
//    }

    System.out.println("Class: " + file.getClass());
    System.out.println("CanExcecute:" + file.canExecute());
    System.out.println("CanRead: " + file.canRead());
    System.out.println("CanWrite: " + file.canWrite());
    System.out.println("Path: " + file.getPath());
    System.out.println("AbsolutePath: " + file.getAbsolutePath());
    System.out.println("AbsolutePath: " + file.getAbsoluteFile());
    System.out.println("CanonicalPath: " + file.getCanonicalPath());
    System.out.println("URI: " + file.toURI());
    System.out.println("Exists: " + file.exists());
    System.out.println("isDirectory: " + file.isDirectory());
    System.out.println("isFile: " + file.isFile());
    System.out.println("isHidden: " + file.isHidden());
    System.out.println("LastModified: " + file.lastModified());
    System.out.println("Length in bytes: " + file.length());
    System.out.println("CreateNewFile: " + file.createNewFile());
    File f = new File("a.txt");
    System.out.println("Create a.txt: " + f.createNewFile());
    System.out.println("Delete a.txt: " + f.delete());
    File folder = new File("myFolder");
    String[] folderContent = folder.list();
    System.out.println("myFolder:");
    for (String item : folderContent) {
      System.out.println(item);
    }


  }

}
