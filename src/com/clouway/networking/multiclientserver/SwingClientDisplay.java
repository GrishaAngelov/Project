package com.clouway.networking.multiclientserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class SwingClientDisplay implements ClientDisplay {

  private JTextArea clientDisplay;
  private JFrame frame;
  private ConnectServerListener connectServerListener;

  @Override
  public void show() {
    clientDisplay = new JTextArea();
    clientDisplay.setEditable(false);
    clientDisplay.setVisible(true);

    frame = new JFrame("Client");
    JScrollPane pane = new JScrollPane(clientDisplay);
    frame.add(pane, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    JButton button = new JButton("connect");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        connectServerListener.onConnect();
      }
    });
    frame.add(button, BorderLayout.SOUTH);
  }

  @Override
  public void writeMessage(String msg) {
    clientDisplay.append(msg);
  }

  @Override
  public void close() {
    frame.dispose();
  }

  @Override
  public void addListener(ConnectServerListener listener) {
    connectServerListener = listener;
  }
}
