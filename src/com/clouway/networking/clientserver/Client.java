package com.clouway.networking.clientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

  private int port;
  private String host;
  private Display clientDisplay;
  private Socket socket;
  private ObjectInputStream objectInputStream;
  private String data;

  /**
   * Takes as parameter specified port number for connection to server
   *
   * @param port - used port by the server
   */
  public Client(String host, int port, Display display) {
    this.host = host;
    this.port = port;
    this.clientDisplay = display;
  }

  /**
   * Starts the client application
   *
   * @throws IOException if an I/O error occurs when creating the socket.
   * @throws ClassNotFoundException when class of a serialized object cannot
   * be found.
   */
  public void connect() throws IOException, ClassNotFoundException {
    try {
      socket = new Socket(host, port);
      clientDisplay.writeMessage("connecting...");
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      clientDisplay.writeMessage("\nconnected");
      data = objectInputStream.readObject().toString();
      clientDisplay.writeMessage(data);
    } finally {
      objectInputStream.close();
      socket.close();
      clientDisplay.writeMessage("\nconnection closed");
    }
  }

  public String getData(){
    return data;
  }
}