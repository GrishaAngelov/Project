package com.clouway.networking.clientserver;

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

public class Server extends JFrame {

  private int port;
  private JTextArea serverDisplay;
  private JButton stopServerButton;
  private ServerSocket serverSocket;
  private Socket socket;
  private ObjectOutputStream objectOutputStream;

  /**
   * Takes as parameter specified port number
   *
   * @param port
   */
  public Server(int port) {
    this.port = port;
    createServerDisplay();
    createStopButton();
  }

  /**
   * Starts the server application
   *
   * @throws IOException
   */
  public void runServer() throws IOException {
    serverSocket = new ServerSocket(port);
    serverDisplay.append("waiting...");
    socket = serverSocket.accept();
    serverDisplay.append("\nconnected");
    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    objectOutputStream.writeObject("ServerMessage");
    objectOutputStream.flush();
    serverDisplay.append("\ndata sent");

  }

  /**
   * Creates server text area
   */
  private void createServerDisplay() {
    serverDisplay = new JTextArea();
    serverDisplay.setEditable(false);
    add(serverDisplay, BorderLayout.CENTER);
  }

  /**
   * Creates a server shutdown button
   */
  private void createStopButton() {
    stopServerButton = new JButton("StopServer");
    stopServerButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          stopServerButton.setEnabled(false);
          objectOutputStream.close();
          serverSocket.close();
          socket.close();
          serverDisplay.append("\nconnection closed");
          closeServerWindow();
        } catch (IOException ex) {
          ex.printStackTrace();
        }

      }
    });
    add(stopServerButton, BorderLayout.SOUTH);
  }

  /**
   * Releases all of the resources used by this window
   */
  private void closeServerWindow() {
    super.dispose();
  }
}
