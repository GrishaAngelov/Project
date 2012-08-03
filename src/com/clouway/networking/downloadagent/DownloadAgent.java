package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgent extends Observable{
  private String filePath;

  public DownloadAgent(String filePath){
    this.filePath = filePath;
  }

  public File downloadFile(String urlString) throws IOException {
    URL url = new URL(urlString);
    URLConnection urlConnection = url.openConnection();
    InputStream connectionInputStream = urlConnection.getInputStream();
    DataInputStream dataInputStream = new DataInputStream(connectionInputStream);

    File file = new File(filePath);
    FileOutputStream fileOutputStream = new FileOutputStream(file);

    int size = urlConnection.getContentLength();
    for (int i = 0; i < size; i++) {
      fileOutputStream.write(dataInputStream.readByte());
      setChanged();
      notifyObservers(i+1);
    }

    closeStreams(connectionInputStream, dataInputStream, fileOutputStream);
    return file;
  }

  private void closeStreams(InputStream inputStream, DataInputStream dataInputStream, OutputStream fileOutputStream) throws IOException {
    inputStream.close();
    dataInputStream.close();
    fileOutputStream.close();
  }
}