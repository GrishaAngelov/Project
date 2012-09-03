package com.clouway.networking.clientserver;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class SwingClientDisplay implements Display {

  private JTextArea clientDisplay;
  private JFrame frame;

  @Override
  public void show() {
    clientDisplay = new JTextArea();
    clientDisplay.setEditable(false);
    clientDisplay.setVisible(true);

    frame = new JFrame("Client");
    frame.add(clientDisplay, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
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
  public void addListener(StopServerListener listener) {
  }
}
