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
  private ConnectedClientsNotifier connectedClientsNotifier = new ConnectedClientsNotifier();
  private ServerDisplayNotifier serverDisplayNotifier = new ServerDisplayNotifier();

  public Server(List<UI> displays) {
    this.displays = displays;
  }

  public void runServer(final int port) throws IOException {

    synchronized (connectedClients) {

      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(200);
          } catch (InterruptedException ignored) {

          }

          while (true) {
            for (int i = 0; i < connectedClients.size(); i++) {
              try {
                if (connectedClients.get(i).getInputStream().read() == -1) {
                  connectedClients.remove(i);
                  notifyAllConnectedClients(connectedClientsNotifier.notifyForClientDisconnection()+connectedClients.size());
                }
              } catch (IOException ignored) {

              }
            }
            try {
              Thread.sleep(300);
            } catch (InterruptedException e) {

            }
          }
        }
      }).start();
    }


    synchronized (connectedClients) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            serverSocket = new ServerSocket(port);
          } catch (IOException ignored) {

          }

          while (!Thread.currentThread().isInterrupted()) {

            try {
              notifyDisplaysWith(serverDisplayNotifier.notifyWaitingForConnection());

              Socket socket = serverSocket.accept();

              socket.setSoTimeout(300);

              notifyDisplaysWith(serverDisplayNotifier.notifyForConnectedClient());

              PrintWriter writer = new PrintWriter(socket.getOutputStream());

              writer.println(connectedClientsNotifier.notifyConnectedClientForHisCounter() + (connectedClients.size() + 1));


              writer.flush();

              notifyAllConnectedClients(connectedClientsNotifier.notifyForNewConnection() + (connectedClients.size() + 1));

              connectedClients.add(socket);

            } catch (IOException ignored) {

            }
          }
        }

      }).start();
    }
  }

  private void notifyAllConnectedClients(String message) throws IOException {
    for (Socket clientSocket : connectedClients) {

      PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());

      printWriter.println(message);

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
