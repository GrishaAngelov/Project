package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
  public static void main(String[] args) throws ClassNotFoundException, IOException {
    ClientGUI clientGUI = new ClientGUI();
    clientGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    clientGUI.setSize(500, 200);
    clientGUI.setVisible(true);
    clientGUI.setResizable(false);
    clientGUI.runClient();
  }
}
