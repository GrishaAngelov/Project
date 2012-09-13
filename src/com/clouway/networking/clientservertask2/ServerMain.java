package com.clouway.networking.clientservertask2;

import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerMain {
  public static void main(String[] args) throws IOException {
    DateProvider dateProvider = new DateProvider();
    DisplayController serverDisplay = new ServerDisplay();
    Server server = new Server(1580, dateProvider, serverDisplay);
    server.runServer();
  }
}
