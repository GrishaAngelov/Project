package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Client extends JFrame {
  private JTextArea textArea;
  private JButton connectButton;
  private Socket client;
  private ObjectInputStream inputStream;

  public void runClient() throws IOException, ClassNotFoundException {
    setTitle("Client");
    setUpTextArea();
    setConnectButton();
  }

  private void setUpTextArea() {
    textArea = new JTextArea();
    textArea.setEditable(false);
    add(textArea, BorderLayout.CENTER);
  }

  private void setConnectButton() throws IOException {
    connectButton = new JButton("Connect");
    connectButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        try {
          connectButton.setEnabled(false);
          setUpClientAndConnection();
          getClientInputStream();
          getDataFromServer();
          closeConnection();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
    });
    add(connectButton,BorderLayout.SOUTH);

  }

  private void setUpClientAndConnection() throws IOException {
    client = new Socket(InetAddress.getByName("localhost"), 1356);
    display("Connected to server");
  }

  private void getClientInputStream() throws IOException {
    inputStream = new ObjectInputStream(client.getInputStream());
    display("Got input stream");
  }

  public String getDataFromServer() throws IOException, ClassNotFoundException {
    String data = inputStream.readObject().toString();
    display("Data received: " + data);
    return data;
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
    inputStream.close();
    client.close();
    display("Connection closed");
  }
}
