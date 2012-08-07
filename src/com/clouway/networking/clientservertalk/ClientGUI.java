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
public class ClientGUI extends JFrame {
  private JTextArea textArea;
  private JButton connectButton;


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
    connectButton.addActionListener(new ConnectButtonHandler(textArea, connectButton));
    add(connectButton,BorderLayout.SOUTH);

  }
}
