package com.clouway.networking.clientserver;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Client client = new Client(1589);
    client.setTitle("Client");
    client.setVisible(true);
    client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    client.setSize(300, 200);
    client.runClient();
  }
}
