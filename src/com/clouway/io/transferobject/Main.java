package com.clouway.io.transferobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args){
    TransferObject transferObject = new TransferObject();
    try{
    InputStream input = new FileInputStream("In.txt");
    OutputStream output = new FileOutputStream("Out.txt");

    int BytesTransferred = transferObject.transfer(input, output, 1, 5);
    System.out.println("Number of transferred bytes: " + BytesTransferred);
    }catch (IOException ex){
      ex.printStackTrace();
    }
  }
}
