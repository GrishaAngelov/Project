package com.clouway.networking.multiclientserver;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerMain {
  public static void main(String[] args) {
    ServerDisplay display = new SwingServerDisplay();
    final Server server = new Server(1589, display);
    display.show();
    new Thread(new Runnable() {
      @Override
      public void run() {
        server.runServer();
      }
    }).start();
  }
}
