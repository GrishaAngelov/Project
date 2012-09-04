package com.clouway.networking.clientserverapp;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;

public class ServerMain {
  public static void main(String[] args) throws IOException {
    DisplayController display = new ServerDisplay();
    Server server = new Server(1589, display);
    server.runServer();
  }
}