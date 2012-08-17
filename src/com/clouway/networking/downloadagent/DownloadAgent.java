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

  /**
   * Adds an observer that will listen for change in the progress status
   *
   * @param progressObserver
   */
  @Override
  public void addObserver(ProgressObserver progressObserver) {
    progressObserverList.add(progressObserver);
  }

  /**
   * Downloads a specific web resource
   *
   * @param inputStream   - from the resource
   * @param outputStream  - to store downloaded content
   * @param contentLength - size of resource content
   * @throws IOException if an error occur during downloading
   */
  public void download(InputStream inputStream, OutputStream outputStream, int contentLength) throws IOException {
    final InputStream is = inputStream;
    final OutputStream os = outputStream;

    size = contentLength;

    try {
      int currentReadByte;
      int currentProgress;
      int lastProgress = 0;
      double countByte = 1.0;
      while ((currentReadByte = is.read()) != -1) {
        os.write(currentReadByte);
        for (ProgressObserver progressObserver : progressObserverList) {
          currentProgress = (int) ((countByte / size) * 100.0);
          if (currentProgress != lastProgress) {
            progressObserver.update(currentProgress);
            lastProgress = currentProgress;
          }
          countByte++;
        }
      }
    } finally {
      is.close();
      os.close();
    }
  }
}