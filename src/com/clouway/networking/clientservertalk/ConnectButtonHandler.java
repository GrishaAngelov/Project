package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ConnectButtonHandler implements ActionListener {
  private JTextArea textArea;
  private JButton connectButton;
  private Socket client;
  private ObjectInputStream inputStream;
  private int port = 1356;

  public ConnectButtonHandler(JTextArea textArea, JButton button) {
    this.textArea = textArea;
    this.connectButton = button;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      connectButton.setEnabled(false);
      setUpClient();
      getClientInputStream();
      getDataFromServer();
      closeConnection();
    } catch (IOException e) {
      textArea.append("An error occurred: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private void setUpClient() throws IOException {
    client = new Socket(InetAddress.getByName("localhost"), port);
    textArea.append("Connected to server\n");
  }

  private void getClientInputStream() throws IOException {
    inputStream = new ObjectInputStream(client.getInputStream());
    textArea.append("Got input stream\n");
  }

  public String getDataFromServer() throws IOException, ClassNotFoundException {
    String data = inputStream.readObject().toString();
    textArea.append("Data received: " + data + "\n");
    return data;
  }

  private void closeConnection() throws IOException {
    inputStream.close();
    client.close();
    textArea.append("Connection closed");
  }
}
