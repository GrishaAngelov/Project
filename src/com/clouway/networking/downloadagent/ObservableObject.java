package com.clouway.networking.downloadagent;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ObservableObject {
  void addObserver(ProgressObserver progressObserver);
}
