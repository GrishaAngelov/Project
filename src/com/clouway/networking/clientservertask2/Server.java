package com.clouway.networking.clientservertask2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Server {
  private ServerSocket serverSocket;
  private List<UI> displays;
  private List<Socket> connectedClients = Collections.synchronizedList(new ArrayList<Socket>());

  public Server(List<UI> displays) {
    this.displays = displays;
  }

  public void runServer(int port) throws IOException {

    serverSocket = new ServerSocket(port);

    new Thread(new Runnable() {
      @Override
      public void run() {

        while (Thread.currentThread().isAlive()) {

          try {
            notifyDisplaysWith("\nwaiting");

            Socket socket = serverSocket.accept();

            notifyDisplaysWith("\nconnected");

            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            writer.println("you are " + (connectedClients.size() + 1));

            writer.flush();

            notifyAllConnectedClientsForNewClientConnection();

            connectedClients.add(socket);

          } catch (IOException e) {

          }
        }
      }

    }).start();
  }

  private void notifyAllConnectedClientsForNewClientConnection() throws IOException {
    for (Socket clientSocket : connectedClients) {

      PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

      printWriter.println("Client #" + (connectedClients.size() + 1) + " has connected");

      printWriter.flush();
    }
  }

  private void notifyDisplaysWith(String message) {
    for (UI display : displays) {
      display.displayMessage(message);
    }
  }

  public void closeServer() throws IOException {
    serverSocket.close();
  }
}
