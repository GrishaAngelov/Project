package com.clouway.networking.downloadagent;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ProgressObserver {
  void update(int value);
  void setMaxValue(int value);
}
