package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) throws ClassNotFoundException, IOException {
    Client client = new Client();
    client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    client.setSize(500, 200);
    client.setVisible(true);
    client.setResizable(false);
    client.runClient();
  }
}
