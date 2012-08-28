package com.clouway.networking.multiclientserver;

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
   * Constructor takes as parameter specified port for connection to server
   *
   * @param port
   */
  public Client(int port) {
    this.port = port;
    createClientDisplay();
  }

  /**
   * Starts the client
   */

  public void runClient() {
    try {
      clientDisplay.setText("");
      socket = new Socket("127.0.0.1", port);
      clientDisplay.append("connecting...");
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      clientDisplay.append("\nconnected");

      while (true) {
        data = (String) objectInputStream.readObject();
        clientDisplay.append(data);
      }

    } catch (IOException ex) {
      clientDisplay.append("\nconnection is closed by server");
      closeConnection();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }

  }

  /**
   * Creates client text area
   */
  private void createClientDisplay() {
    clientDisplay = new JTextArea();
    clientDisplay.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(clientDisplay);
    add(scrollPane, BorderLayout.CENTER);
  }

  /**
   * @return received data from server
   */
  public String getData() {
    return data;
  }

  /**
   * Closes the connection with server
   */
  public void closeConnection() {
    try {
      objectInputStream.close();
      socket.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
