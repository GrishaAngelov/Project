package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Server extends JFrame {
  private JTextArea textArea;
  private JButton stopButton;
  private ServerSocket serverSocket;
  private Socket clientConnection;
  private int port = 1356;
  private ObjectOutputStream outputStream;

  public void runServer() throws IOException {
    setTitle("Server");
    setUpTextArea();
    setStopButton();
    setUpServerAndConnection();
    getClientOutputStream();
    sendDataToClient();
  }

  private void setUpTextArea() {
    textArea = new JTextArea();
    textArea.setEditable(false);
    add(textArea, BorderLayout.CENTER);
  }

  private void setStopButton() {
    stopButton = new JButton("Stop Server");
    stopButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        try {
          closeConnection();
          stopButton.setEnabled(false);
        } catch (IOException e) {
          display("Error while closing connection");
        }
      }
    });
    add(stopButton, BorderLayout.SOUTH);
  }

  private void setUpServerAndConnection() throws IOException {
    serverSocket = new ServerSocket(port);
    display("Waiting for connection...");
    clientConnection = serverSocket.accept();
    display("Connection received");
  }

  private void getClientOutputStream() throws IOException {
    outputStream = new ObjectOutputStream(clientConnection.getOutputStream());
    outputStream.flush();
    display("Got output stream");
  }

  private void sendDataToClient() {
    try {
      String data = "Current Date And Time - " + new Date().toString();
      outputStream.writeObject(data);
      outputStream.flush();
      display("Data sent: " + data);
    } catch (IOException e) {
      display("Error while sending to client");
    }
  }

  private void display(final String message) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        textArea.append(message + "\n");
      }
    });
  }

  private void closeConnection() throws IOException {
    outputStream.close();
    serverSocket.close();
    display("Connection closed");
  }
}
