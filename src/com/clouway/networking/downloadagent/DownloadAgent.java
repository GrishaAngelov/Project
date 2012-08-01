package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgent {
  private File file;
  private JProgressBar progressBar;

  public DownloadAgent(File file, JProgressBar progressBar) {
    this.file = file;
    this.progressBar = progressBar;
  }

  public File downloadFile(String urlString) throws IOException {
    URL url = new URL(urlString);
    URLConnection urlConnection = url.openConnection();
    InputStream connectionInputStream = urlConnection.getInputStream();
    DataInputStream dataInputStream = new DataInputStream(connectionInputStream);

    FileOutputStream fileOutputStream = new FileOutputStream(file);

    int size = urlConnection.getContentLength();
    for (int i = 0; i < size; i++) {
      fileOutputStream.write(dataInputStream.readByte());
      progressBar.setValue(i + 1);
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
