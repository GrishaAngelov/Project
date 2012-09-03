package com.clouway.networking.multiclientserver;


import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) throws ClassNotFoundException, IOException {
    ClientDisplay clientDisplay = new SwingClientDisplay();
    new Client("127.0.0.1", 1589, clientDisplay);
    clientDisplay.show();
  }
}
