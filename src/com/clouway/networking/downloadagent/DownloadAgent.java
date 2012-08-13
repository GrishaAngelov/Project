package com.clouway.networking.downloadagent;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgent implements ObservableObject {
  private List<ProgressObserver> progressObserverList = new ArrayList<ProgressObserver>();
  private DataInputStream dataInputStream;
  private FileOutputStream fileOutputStream;
  private int size = 0;
  private int maxValue;

  @Override
  public void addObserver(ProgressObserver progressObserver) {
    progressObserverList.add(progressObserver);
  }

  public void download(URLConnection connectionInputStream, String filePath) throws IOException {

    dataInputStream = new DataInputStream(connectionInputStream.getInputStream());
    File file = new File(filePath);
    fileOutputStream = new FileOutputStream(file);
    size = connectionInputStream.getContentLength();
    maxValue = size;

    for (ProgressObserver progressObserver : progressObserverList) {
      progressObserver.setMaxValue(maxValue);
    }

    Thread updateThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          for (int i = 0; i < maxValue; i++) {
            for (ProgressObserver observer : progressObserverList) {
              fileOutputStream.write(dataInputStream.readByte());
              observer.update((maxValue - size) + 1);
              size--;
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          try {
            dataInputStream.close();
            fileOutputStream.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    });
    updateThread.start();
  }
}