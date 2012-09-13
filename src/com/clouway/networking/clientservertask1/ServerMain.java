package com.clouway.networking.clientservertask1;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;

public class ServerMain {
  public static void main(String[] args) throws IOException {
    DisplayController display = new ServerDisplay();
    DateProvider dateProvider = new DateProvider();
    Server server = new Server(1589, dateProvider, display);
    server.runServer();
  }
}