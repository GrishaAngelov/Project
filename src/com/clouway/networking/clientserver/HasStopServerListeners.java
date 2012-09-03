package com.clouway.networking.clientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface HasStopServerListeners {
  void addListener(StopServerListener listener);
}
