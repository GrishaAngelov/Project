package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgent implements Runnable {
  private String filePath;
  private InputStream connectionInputStream;
  private DataInputStream dataInputStream;
  private FileOutputStream fileOutputStream;
  private File file;
  private int size = 0;
  private JProgressBar progressBar;

  public  DownloadAgent(String filePath) {
    this.filePath = filePath;
  }

  public void setProgressBar(JProgressBar progressBar) {
    this.progressBar = progressBar;
  }

  public File downloadFile(String urlString) throws IOException {
    URL url = new URL(urlString);
    URLConnection urlConnection = url.openConnection();
    connectionInputStream = urlConnection.getInputStream();
    dataInputStream = new DataInputStream(connectionInputStream);

    file = new File(filePath);
    fileOutputStream = new FileOutputStream(file);
    size = urlConnection.getContentLength();

    new Thread(this).start();
    return file;
  }

  @Override
  public void run() {
    try {
      progressBar.setMaximum(size);
      for (int i = 0; i < progressBar.getMaximum(); i++) {
        fileOutputStream.write(dataInputStream.readByte());
        progressBar.setValue((progressBar.getMaximum() - size) + 1);
        size--;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        connectionInputStream.close();
        dataInputStream.close();
        fileOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}