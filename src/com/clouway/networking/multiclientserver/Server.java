package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class Server extends JFrame implements Runnable {

  private int port;
  private JTextArea serverDisplay;
  private JButton stopServerButton;
  private ServerSocket serverSocket;
  private Socket socket;
  private ObjectOutputStream objectOutputStream;
  private int currentClientNumber = 0;
  private boolean stop = false;
  private Map<Socket, ObjectOutputStream> clients = new Hashtable<Socket, ObjectOutputStream>();

  /**
   * Constructor takes as parameter specified port number
   *
   * @param port
   */
  public Server(int port) {
    this.port = port;
    createServerDisplay();
    createStopButton();
  }

  /**
   * Starts the server thread
   */
  @Override
  public void run() {
    try {
      serverSocket = new ServerSocket(port);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    while (!stop) {
      try {
        serverDisplay.append("\nwaiting for client...");
        socket = serverSocket.accept();

        currentClientNumber++;
        serverDisplay.append("\nconnected");

        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        clients.put(socket, objectOutputStream);
        objectOutputStream.writeObject("\nyou are: " + currentClientNumber);
        objectOutputStream.flush();

        new Thread(new Notificator(socket, clients)).start();

        objectOutputStream.writeObject("\nreceived: " + new Date().toString());
        objectOutputStream.flush();
        serverDisplay.append("\ndata sent\n");
      } catch (IOException ex) {
        serverDisplay.append("\nconnection is closed");

      }
    }

  }

  /**
   * Creates server text area
   */
  private void createServerDisplay() {
    serverDisplay = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(serverDisplay);
    serverDisplay.setEditable(false);
    add(scrollPane, BorderLayout.CENTER);
  }

  /**
   * Creates stopServer button
   */
  private void createStopButton() {
    stopServerButton = new JButton("StopServer");
    stopServerButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        closeConnection();

      }
    });
    add(stopServerButton, BorderLayout.SOUTH);
  }

  /**
   * Close the connection with clients
   */
  public void closeConnection() {
    try {
      stopServerButton.setEnabled(false);
      objectOutputStream.close();
      serverSocket.close();
      socket.close();
      stop = true;
      closeServerWindow();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Releases all of the resources used by this window
   */
  private void closeServerWindow() {
    super.dispose();
  }
}