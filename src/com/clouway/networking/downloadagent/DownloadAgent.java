package com.clouway.networking.downloadagent;

import java.io.*;
import java.net.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgent {

  public File downloadFile(String urlString) throws IOException {
    URL url = new URL(urlString);
    URLConnection urlConnection = url.openConnection();
    InputStream connectionInputStream = urlConnection.getInputStream();
    DataInputStream dataInputStream = new DataInputStream(connectionInputStream);

    int size = urlConnection.getContentLength();
    byte[] fileData = new byte[size];
    for (int i = 0; i < size; i++) {
      fileData[i] = dataInputStream.readByte();
    }

    String filename = urlString.substring(urlString.lastIndexOf("/") + 1);
    File file = new File(filename);
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    fileOutputStream.write(fileData);

    closeStreams(connectionInputStream, dataInputStream, fileOutputStream);
    return file;
  }

  private void closeStreams(InputStream inputStream, DataInputStream dataInputStream, OutputStream fileOutputStream) throws IOException {
    inputStream.close();
    dataInputStream.close();
    fileOutputStream.close();
  }
}
