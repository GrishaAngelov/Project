package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ClientDisplay extends HasConnectServerListeners {
  void show();

  void writeMessage(String msg);

  void close();
}