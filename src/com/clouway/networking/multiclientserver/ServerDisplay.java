package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ServerDisplay extends HasStopServerListeners {

  void show();

  void writeMessage(String msg);

  void close();

}
