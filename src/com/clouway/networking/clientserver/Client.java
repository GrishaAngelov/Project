package com.clouway.networking.clientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client extends JFrame {

  private int port;
  private JTextArea clientDisplay;
  private Socket socket;
  private ObjectInputStream objectInputStream;
  private String data;

  /**
   * Takes as parameter specified port number for connection to server
   *
   * @param port - used port by the server
   */
  public Client(int port) {
    this.port = port;
    createClientDisplay();
  }

  /**
   * Starts the client application
   *
   * @throws IOException if an I/O error occurs when creating the socket.
   * @throws ClassNotFoundException when class of a serialized object cannot be found.
   */
  public void runClient() throws IOException, ClassNotFoundException {
    try {
      socket = new Socket("127.0.0.1", port);
      clientDisplay.append("connecting...");
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      clientDisplay.append("\nconnected");
      data = objectInputStream.readObject().toString();
      clientDisplay.append("\nreceived: " + data);
    } finally {
      objectInputStream.close();
      socket.close();
      clientDisplay.append("\nconnection closed");
    }
  }

  /**
   * Creates client text area
   */
  private void createClientDisplay() {
    clientDisplay = new JTextArea();
    clientDisplay.setEditable(false);
    add(clientDisplay, BorderLayout.CENTER);
  }

  /**
   * @return received data
   */
  public String getData() {
    return data;
  }
}