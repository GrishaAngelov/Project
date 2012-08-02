package com.clouway.javahowtoprogramnetworking.clientserverinteraction;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) {
    Client client = new Client("127.0.0.1");
    client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    client.runClient();
  }
}
