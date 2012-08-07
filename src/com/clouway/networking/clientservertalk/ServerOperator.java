package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerOperator {
  private JTextArea textArea;
  private JButton stopButton;
  private ServerSocket serverSocket;
  private int port = 1356;
  private Socket clientConnection;
  private ObjectOutputStream outputStream;


  public ServerOperator(JTextArea textArea, JButton button) {
    this.textArea = textArea;
    this.stopButton = button;
  }

  public void runServer() throws IOException {
    setUpServer();
    setUpConnection();
    getClientOutputStream();
    sendDataToClient();
    addListener();
  }

  private void setUpServer() throws IOException {
    serverSocket = new ServerSocket(port);
    textArea.append("Waiting for connection...\n");

  }

  private void setUpConnection() throws IOException {
    clientConnection = serverSocket.accept();
    textArea.append("Connection received\n");
  }

  private void getClientOutputStream() throws IOException {
    outputStream = new ObjectOutputStream(clientConnection.getOutputStream());
    outputStream.flush();
    textArea.append("Got output stream\n");
  }

  private void sendDataToClient() {
    try {
      String data = "Current Date And Time - " + new Date().toString();
      outputStream.writeObject(data);
      outputStream.flush();
      textArea.append("Data sent: " + data + "\n");
    } catch (IOException e) {
      textArea.append("Error while sending to client\n");
    }
  }

  private void addListener() {
    stopButton.addActionListener(new StopButtonHandler(textArea, stopButton, serverSocket, outputStream));
  }
}
