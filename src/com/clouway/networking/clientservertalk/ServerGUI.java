package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerGUI extends JFrame {
  private JTextArea textArea;
  private JButton stopButton;
  private ServerOperator serverOperator;

  public void runServer() {
    setTitle("Server");
    setUpTextArea();
    setStopButton();
    setUpServerOperatorAndRunServer();
  }

  private void setUpTextArea() {
    textArea = new JTextArea();
    textArea.setEditable(false);
    add(textArea, BorderLayout.CENTER);
  }

  private void setStopButton() {
    stopButton = new JButton("Stop Server");
    add(stopButton, BorderLayout.SOUTH);
  }

  private void setUpServerOperatorAndRunServer()  {
    try {
      serverOperator = new ServerOperator(textArea, stopButton);
      serverOperator.runServer();
    } catch (IOException e) {
      textArea.append("Error running server\n");
    }
  }
}
