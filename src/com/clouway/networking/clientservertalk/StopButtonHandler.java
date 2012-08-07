package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class StopButtonHandler implements ActionListener {
  private JTextArea textArea;
  private JButton stopButton;
  private ServerSocket serverSocket;
  private ObjectOutputStream outputStream;

  public StopButtonHandler(JTextArea textArea, JButton button, ServerSocket serverSocket, ObjectOutputStream outputStream) {
    this.textArea = textArea;
    this.stopButton = button;
    this.serverSocket = serverSocket;
    this.outputStream = outputStream;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      stopButton.setEnabled(false);
      outputStream.close();
      serverSocket.close();
      textArea.append("Connection closed\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
