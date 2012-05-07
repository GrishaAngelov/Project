package com.clouway.io.dataclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DataClass dataClass = new DataClass();
    Student student = new Student("Johhn", 21);
    File serializationFile = new File("student.ser");
    if (!serializationFile.exists()) {
      serializationFile.createNewFile();
    }
    FileOutputStream fileOutputStream = null;
    FileInputStream fileInputStream = null;
    try {
      fileOutputStream = new FileOutputStream(serializationFile);
      dataClass.saveObject(fileOutputStream, student);

      fileInputStream = new FileInputStream(serializationFile);
      Student studentObject = (Student) dataClass.getObject(fileInputStream);
      System.out.println("name: " + studentObject.getName());
      System.out.println("age: " + studentObject.getAge());
    } finally {
      fileOutputStream.close();
      fileInputStream.close();
    }

  }
}
