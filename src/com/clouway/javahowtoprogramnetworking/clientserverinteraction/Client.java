package com.clouway.javahowtoprogramnetworking.clientserverinteraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Client extends JFrame {
  private JTextField enterField;
  private JTextArea displayArea;
  private ObjectOutputStream outputStream;
  private ObjectInputStream inputStream;
  private String message = "";
  private String chatServer;
  private Socket clientSocket;

  public Client(String host) {
    setTitle("Client");
    chatServer = host;

    setUpAndAddEnterField();
    setUpDisplayArea();
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

  private void setUpDisplayArea() {
    displayArea = new JTextArea();
    add( new JScrollPane( displayArea ), BorderLayout.CENTER );
    setSize( 300, 150 );
    setVisible( true );
  }

  public void runClient() {
    try {
      connectToServer();
      getStreams();
      processConnection();
    } catch (EOFException e) {
      displayMessage("\nClient terminated connection");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }

  private void connectToServer() throws IOException {
    displayMessage("Attempting connection\n");
    clientSocket = new Socket(InetAddress.getByName(chatServer), 12345);
    displayMessage("Connect to " + clientSocket.getInetAddress().getHostName());
  }

  private void getStreams() throws IOException {
    outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
    outputStream.flush();
    inputStream = new ObjectInputStream(clientSocket.getInputStream());
    displayMessage("\nGot I/O Streams\n");
  }

  private void processConnection() throws IOException {
    setTextFieldEditable(true);
    do {
      try {
        message = (String) inputStream.readObject();
        displayMessage("\n" + message);
      } catch (ClassNotFoundException e) {
        displayMessage("\nUnknown object type received");
      }
    } while (!message.equals("SERVER>>> TERMINATE"));
  }

  private void closeConnection() {
    displayMessage("\nClosing connection");
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
      outputStream.writeObject("CLIENT>>> " + message);
      outputStream.flush();
      displayMessage("\nCLIENT>>>" + message);
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

  private void setTextFieldEditable(final boolean editable) {
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
