package com.clouway.networking.clientserverapp;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface DisplayController extends DisplayOperation{
  void close();
  void addListener(StopServerListener stopServerListener);
  void addListener(ConnectListener connectListener);
}
