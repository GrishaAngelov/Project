package com.clouway.networking.clientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import javax.swing.*;
import java.io.IOException;

public class ServerMain {
  public static void main(String[] args) throws IOException {
    Server server = new Server(1589);
    server.setTitle("Server");
    server.setVisible(true);
    server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    server.setSize(300, 200);
    server.runServer();
  }
}