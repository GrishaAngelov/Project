package com.clouway.networking.clientservertask2;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */


import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
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
  public synchronized void run() {

    Collection values = clients.values();
    Iterator it = values.iterator();
    synchronized (it) {
      while (it.hasNext()) {
        PrintWriter writer = (PrintWriter) it.next();
        writer.write("\nclient #" + clients.size() + " has connected\n");
        writer.flush();
      }
    }
  }
}