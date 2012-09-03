package com.clouway.networking.multiclientserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SwingServerDisplay implements ServerDisplay {
  private StopServerListener listener;
  private JFrame frame;
  private JTextArea text;
  private JButton stopServerButton;

  @Override
  public void show() {
    frame = new JFrame();
    text = new JTextArea();

    text.setEditable(false);
    JScrollPane pane = new JScrollPane(text);
    frame.add(pane, BorderLayout.CENTER);
    frame.setTitle("Server");
    frame.setSize(300, 200);


    stopServerButton = new JButton("StopServer");

    stopServerButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        stopServerButton.setEnabled(false);
        listener.onStopServer();
      }
    });
    frame.add(stopServerButton, BorderLayout.SOUTH);
    frame.setVisible(true);
  }

  @Override
  public void writeMessage(String msg) {
    text.append(msg);

  }

  @Override
  public void close() {
    frame.dispose();
  }

  @Override
  public void addListener(StopServerListener listener) {

    this.listener = listener;
  }
}
