package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgent extends Observable {
  private String filePath;
  private InputStream connectionInputStream;
  private DataInputStream dataInputStream;
  private FileOutputStream fileOutputStream;
  private File file;

  public DownloadAgent(String filePath) {
    this.filePath = filePath;
  }

  public File downloadFile(String urlString) throws IOException {
    try {
      URL url = new URL(urlString);
      URLConnection urlConnection = url.openConnection();
      connectionInputStream = urlConnection.getInputStream();
      dataInputStream = new DataInputStream(connectionInputStream);

      file = new File(filePath);
      fileOutputStream = new FileOutputStream(file);

      int size = urlConnection.getContentLength();
      for (int i = 0; i < size; i++) {
        fileOutputStream.write(dataInputStream.readByte());
        setChanged();
        notifyObservers(i + 1);
      }
    } finally {
      connectionInputStream.close();
      dataInputStream.close();
      fileOutputStream.close();
    }
    return file;
  }
}