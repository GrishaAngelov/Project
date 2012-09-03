package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface HasConnectServerListeners {
  void addListener(ConnectServerListener listener);
}
