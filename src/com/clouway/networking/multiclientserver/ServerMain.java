package com.clouway.networking.multiclientserver;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerMain {
  public static void main(String[] args) {
    Server server = new Server(1589);
    server.setTitle("Server");
    server.setVisible(true);
    server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    server.setSize(300, 200);

    new Thread(server).start();
  }
}
