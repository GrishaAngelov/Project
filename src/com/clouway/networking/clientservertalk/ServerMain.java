package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerMain {
  public static void main(String[] args) throws IOException {
    Server server = new Server();
    server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    server.setSize(500, 200);
    server.setVisible(true);
    server.setResizable(false);
    server.runServer();
  }
}
