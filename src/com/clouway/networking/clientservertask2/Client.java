package com.clouway.networking.clientservertask2;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Client {
  public UI clientUI;
  private Socket socket;
  private Scanner scanner;


  public Client(UI clientUI) {
    this.clientUI = clientUI;
  }

  public void connect(String host, int port) throws IOException {
    socket = new Socket(host, port);
    scanner = new Scanner(socket.getInputStream());
    try {
      while (socket.isConnected()) {
        clientUI.displayMessage("\n" + scanner.nextLine());
      }
    } catch (NoSuchElementException e) {
      clientUI.displayMessage("\nconnection is closed");
      close();
    }
  }

  public void close() throws IOException {
    scanner.close();
    socket.close();
  }
}
