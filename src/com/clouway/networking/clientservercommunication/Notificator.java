package com.clouway.networking.clientservercommunication;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */


import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class Notificator implements Runnable {

  private Map<Socket, PrintWriter> clients;

  public Notificator(Map<Socket, PrintWriter> clients) {
    this.clients = clients;
  }

  /**
   * Sends notification message to all clients
   */
  @Override
  public void run() {
    for (Map.Entry<Socket, PrintWriter> client : clients.entrySet()) {
      {
        client.getValue().write("\nclient #" + clients.size() + " has connected\n");
        client.getValue().flush();
      }
    }
  }
}