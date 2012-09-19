package com.clouway.networking.clientservertask2;

import java.io.IOException;
import java.net.ConnectException;
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
  private boolean stop = false;


  public Client(UI clientUI) {
    this.clientUI = clientUI;
  }

  public void connect(String host, int port) throws IOException {
    try{
    socket = new Socket(host, port);
    scanner = new Scanner(socket.getInputStream());
    try {
      while (!stop) {
        clientUI.displayMessage("\n" + scanner.nextLine());
      }
    } catch (NoSuchElementException e) {
      clientUI.displayMessage("\nconnection is closed");
      close();
    }
    }catch (ConnectException e){
      clientUI.displayMessage("Server is not started");
    }

  }

  public void close() throws IOException {
    stop = true;
    if (socket != null) {
      socket.close();
    }
  }
}
