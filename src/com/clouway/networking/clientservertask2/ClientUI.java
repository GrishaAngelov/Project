package com.clouway.networking.clientservertask2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientUI implements UI {
  private JTextArea textArea = new JTextArea();
  private JFrame clientUI;

  public ClientUI() {
    buildClientUI();
  }

  private void buildClientUI() {
    clientUI = new JFrame("Client");
    textArea.setEditable(false);
    clientUI.add(new JScrollPane(textArea), BorderLayout.CENTER);
    clientUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    clientUI.setSize(250, 300);
    clientUI.setVisible(true);
    clientUI.setResizable(false);
  }

  @Override
  public void displayMessage(String message) {
    textArea.append(message);
  }
}
