package com.clouway.networking.clientservertask1;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface DisplayController extends DisplayOperation {
  void close();

  void addListener(StopServerListener stopServerListener);

  void addListener(ConnectionListener connectionListener);
}
