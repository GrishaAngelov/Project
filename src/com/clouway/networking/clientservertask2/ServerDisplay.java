package com.clouway.networking.clientservertask2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerDisplay implements DisplayController {
  private JTextArea serverDisplay = new JTextArea();
  private JButton stopButton = new JButton("Stop Server");
  private JFrame serverUI = new JFrame("Server");
  private StopServerListener stopServerListener;

  public ServerDisplay() {
    buildServerUI();
  }

  private void buildServerUI() {
    serverUI.setSize(300, 200);
    serverUI.setVisible(true);

    serverDisplay.setEditable(false);
    serverUI.add(serverDisplay, BorderLayout.CENTER);


    stopButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        stopServerListener.onStopServer();
      }
    });
    serverUI.add(stopButton, BorderLayout.SOUTH);
  }

  @Override
  public void close() {
    serverUI.dispose();
  }

  @Override
  public void addListener(StopServerListener stopServerListener) {
    this.stopServerListener = stopServerListener;
  }

  @Override
  public void addListener(ConnectionListener connectionListener) {
  }

  @Override
  public void writeMessage(String message) {
    serverDisplay.append(message);
  }

  @Override
  public void clearDisplay() {
    serverDisplay.setText("");
  }
}
