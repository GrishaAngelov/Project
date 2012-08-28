package com.clouway.networking.multiclientserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) {
    final Client client = new Client(1589);
    client.setTitle("Client");
    client.setVisible(true);
    client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    client.setSize(300, 200);

    JButton button = new JButton("connect");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            client.runClient();
          }
        }).start();
      }
    });
    client.add(button, BorderLayout.SOUTH);
  }
}
