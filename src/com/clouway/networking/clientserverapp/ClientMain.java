package com.clouway.networking.clientserverapp;

import java.io.IOException;

/**
* @author Grisha Angelov <grisha.angelov@clouway.com>
*/
public class ClientMain {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DisplayController clientDisplay = new ClientDisplay();
    new Client("127.0.0.1", 1589, clientDisplay);
  }
}
