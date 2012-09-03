package com.clouway.networking.clientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import javax.swing.*;
import java.io.IOException;

public class ServerMain {
  public static void main(String[] args) throws IOException {
    SwingServerDisplay display = new SwingServerDisplay();
    Server server = new Server(1589, display);
    display.show();
    server.runServer();
  }
}