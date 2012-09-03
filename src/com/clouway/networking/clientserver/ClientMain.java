package com.clouway.networking.clientserver;

import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Display clientDisplay = new SwingClientDisplay();
    Client client = new Client("127.0.0.1", 1589, clientDisplay);
    clientDisplay.show();
    client.connect();
  }
}
