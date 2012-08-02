package com.clouway.javahowtoprogramnetworking.clientserverinteraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Server extends JFrame {
  private JTextField enterField;
  private JTextArea displayArea;
  private ObjectOutputStream outputStream;
  private ObjectInputStream inputStream;
  private ServerSocket serverSocket;
  private Socket clientSocket;
  private int counter = 1;

  public Server() {
    setTitle("Server");

    setUpAndAddEnterField();

    setUpAndAddDisplayArea();
  }

  private void setUpAndAddEnterField() {
    enterField = new JTextField();
    enterField.setEditable(false);
    enterField.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                sendData(event.getActionCommand());
                enterField.setText("");
              }
            }
    );
    add(enterField, BorderLayout.NORTH);
  }

  private void setUpAndAddDisplayArea() {
    displayArea = new JTextArea();
    add(new JScrollPane(displayArea), BorderLayout.CENTER);
    setSize(300, 150);
    setVisible(true);
  }

  public void runServer() {
    try {
      serverSocket = new ServerSocket(12345, 10);

      while (true) {
        try {
          waitForConnection();
          getStreams();
          processConnection();
        } catch (EOFException e) {
          displayMessage("\nServer terminated connection");
        } finally {
          closeConnection();
          counter++;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void waitForConnection() throws IOException {
    displayMessage("Waiting for connection\n");
    clientSocket = serverSocket.accept();
    displayMessage(String.format("Connection %s received from: %s", counter, clientSocket.getInetAddress().getHostName()));
  }

  private void getStreams() throws IOException {
    outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
    outputStream.flush();// flush output buffer to send header information

    inputStream = new ObjectInputStream(clientSocket.getInputStream());
    displayMessage("\nGot I/O Streams\n");
  }

  private void processConnection() throws IOException {
    String message = "Connection successful";
    sendData(message);
    setTextFieldEditable(true);
    do {
      try {
        message = (String) inputStream.readObject();
        displayMessage(String.format("\n%s", message));
      } catch (ClassNotFoundException e) {
        displayMessage("\nUnknown object type received");
      }
    } while (!message.equals("CLIENT>>> TERMINATE"));
  }

  private void closeConnection() {
    displayMessage("\nTerminating connection\n");
    setTextFieldEditable(false);
    try {
      outputStream.close();
      inputStream.close();
      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void sendData(String message) {
    try {
      outputStream.writeObject("SERVER>>> " + message);
      outputStream.flush();
      displayMessage("\nSERVER>>> " + message);
    } catch (IOException e) {
      displayArea.append("\nError writing object");
    }
  }

  private void displayMessage(final String messageToDisplay) {
    SwingUtilities.invokeLater(
            new Runnable() {
              @Override
              public void run() {
                displayArea.append(messageToDisplay);
              }
            }
    );
  }

  private void setTextFieldEditable(final boolean editable){
    SwingUtilities.invokeLater(
           new Runnable() {
             @Override
             public void run() {
               enterField.setEditable(editable);
             }
           }
    );
  }
}
