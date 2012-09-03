package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface HasStopServerListeners {
  void addListener(StopServerListener listener);
}
