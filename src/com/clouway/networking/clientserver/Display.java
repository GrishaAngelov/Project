package com.clouway.networking.clientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface Display extends HasStopServerListeners {

  void show();

  void writeMessage(String msg);

  void close();

}
