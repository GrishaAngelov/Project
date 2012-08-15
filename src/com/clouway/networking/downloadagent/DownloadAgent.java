package com.clouway.networking.downloadagent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgent implements ObservableObject {
  private List<ProgressObserver> progressObserverList = new ArrayList<ProgressObserver>();
  private int size = 0;
  private int maxValue;

  @Override
  public void addObserver(ProgressObserver progressObserver) {
    progressObserverList.add(progressObserver);
  }

  public void download(InputStream inputStream, OutputStream outputStream, int contentLength) throws IOException {
    final InputStream is = inputStream;
    final OutputStream os = outputStream;

    size = contentLength;
    maxValue = size;

    for (ProgressObserver progressObserver : progressObserverList) {
      progressObserver.setMaxValue(maxValue);
    }

    Thread updateThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          for (int i = 0; i < maxValue; i++) {
            for (ProgressObserver progressObserver : progressObserverList) {
              os.write(is.read());
              progressObserver.update((maxValue - size) + 1);
              size--;
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          try {
            is.close();
            os.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    });
    updateThread.start();
  }
}