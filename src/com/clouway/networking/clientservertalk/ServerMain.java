package com.clouway.networking.clientservertalk;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerMain {
  public static void main(String[] args) throws IOException {
    ServerGUI serverGUI = new ServerGUI();
    serverGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    serverGUI.setSize(500, 200);
    serverGUI.setVisible(true);
    serverGUI.setResizable(false);
    serverGUI.runServer();
  }
}
