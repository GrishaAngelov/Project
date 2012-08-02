package com.clouway.javahowtoprogramnetworking.clientserverinteraction;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerMain {
  public static void main(String[] args) {
    Server server = new Server();
    server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    server.runServer();
  }
}
