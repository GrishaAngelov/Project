package com.clouway.networking.clientservertask1;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Client {
  private UI clientUI;
  private Socket socket;
  private Scanner scanner;


  public Client(UI clientUI) {
    this.clientUI = clientUI;
  }

  public void connect(String host, int port) throws IOException {
    try{
    socket = new Socket(host, port);
    scanner = new Scanner(socket.getInputStream());
    clientUI.displayMessage(scanner.nextLine());
    close();
    }catch (ConnectException ex){
   clientUI.displayMessage("Server is not started");
    }

  }

  public void close() throws IOException {
    scanner.close();
    socket.close();
    clientUI.displayMessage("\nconnection is closed");
  }
}
