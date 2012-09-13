package com.clouway.networking.clientservertask2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Client {
  private DisplayController clientDisplay;
  private int port;
  private String host;
  private Socket socket;
  private Scanner scanner;
  private boolean stop = false;
  private String data;

  public Client(String host, int port, DisplayController clientDisplay) {
    this.port = port;
    this.host = host;
    this.clientDisplay = clientDisplay;
    clientDisplay.addListener(new ConnectionListener() {
      @Override
      public void onClientConnection() {
        try {
          connect();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }

  public void connect() throws IOException {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          clientDisplay.writeMessage("\nconnecting");
          socket = new Socket(host, port);
          scanner = new Scanner(socket.getInputStream());
          clientDisplay.writeMessage("\nconnected");
          while (!stop) {
            data = scanner.nextLine();
            clientDisplay.writeMessage("\n" + data);
          }
        } catch (NoSuchElementException ex) {
          try {
            close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        } catch (UnknownHostException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }

  public String getData() {
    return data;
  }

  public void close() throws IOException {
    stop = true;
    scanner.close();
    socket.close();
    clientDisplay.writeMessage("\nconnection closed");
  }
}
