package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class Notificator implements Runnable {

  private Map<Socket, ObjectOutputStream> clients;

  public Notificator(Socket socket, Map<Socket, ObjectOutputStream> clients) {
    this.clients = clients;
  }

  /**
   * Sends notification message to all clients
   */
  @Override
  public void run() {
    for (Map.Entry<Socket, ObjectOutputStream> client : clients.entrySet()) {
      try {
        client.getValue().writeObject("\nclient #" + clients.size()+" has connected");
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}