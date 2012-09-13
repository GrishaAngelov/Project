package com.clouway.networking.clientservertask2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class ClientDisplay implements DisplayController {

  private JTextArea clientDisplay = new JTextArea();
  private JFrame clientUI = new JFrame("Client");
  private JButton button = new JButton("Connect");
  private ConnectionListener connectionListener;

  public ClientDisplay() {
    buildClientUI();
  }

  private void buildClientUI() {
    clientUI.setSize(300, 200);
    clientUI.setVisible(true);
    clientUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    clientDisplay.setEditable(false);
    JScrollPane pane = new JScrollPane(clientDisplay);
    clientUI.add(pane, BorderLayout.CENTER);

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        connectionListener.onClientConnection();
      }
    });
    clientUI.add(button,BorderLayout.SOUTH);
  }

  @Override
  public void writeMessage(String message) {
    clientDisplay.append(message);
  }

  @Override
  public void clearDisplay() {
    clientDisplay.setText("");
  }

  @Override
  public void close() {
    clientUI.dispose();
  }

  @Override
  public void addListener(StopServerListener listener) {
  }

  @Override
  public void addListener(ConnectionListener connectionListener) {
    this.connectionListener = connectionListener;
  }
}
