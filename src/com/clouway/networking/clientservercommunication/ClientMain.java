package com.clouway.networking.clientservercommunication;


import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) throws IOException {
    DisplayController clientDisplay = new ClientDisplay();
    new Client("localhost", 1580, clientDisplay);
  }
}
