package com.clouway.networking.clientservercommunication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Server {
  private DisplayController serverDisplay;
  private int port;
  private DateProvider dateProvider;
  private boolean stop = false;
  private PrintWriter printWriter;
  private ServerSocket serverSocket;
  private Socket socket;
  private int currentClientNumber = 0;
  private Map<Socket, PrintWriter> clients = new Hashtable<Socket, PrintWriter>();

  public Server(int port, DateProvider dateProvider, DisplayController serverDisplay) {
    this.port = port;
    this.dateProvider = dateProvider;
    this.serverDisplay = serverDisplay;
    serverDisplay.addListener(new StopServerListener() {
      @Override
      public void onStopServer() {
        try {
          stopServer();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

  }

  public void runServer() throws IOException {
    try {
      serverSocket = new ServerSocket(port);
    } catch (IOException e) {
      e.printStackTrace();
    }


    /*try {
      socket = serverSocket.accept();
    } catch (IOException e) {
    }*/

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (!stop) {
          try {
//            serverDisplay.writeMessage("\nwaiting");
            socket = serverSocket.accept();
            currentClientNumber++;
            serverDisplay.writeMessage("\nconnected");
            if (socket != null) {
              printWriter = new PrintWriter(socket.getOutputStream());

             clients.put(socket, printWriter);

              printWriter.write("\nyou are: " + currentClientNumber + "\n");

              printWriter.write(dateProvider.getCurrentDate());
              printWriter.flush();

              new Thread(new Notificator(clients)).start();

              serverDisplay.writeMessage("\ndata sent");
            }
          } catch (IOException e) {
          }
        }
      }
    }).start();
  }


  public void stopServer() throws IOException {
    serverDisplay.close();
    stop = true;
    if (socket != null) {
      printWriter.close();
      socket.close();
    }
    serverSocket.close();
    serverDisplay.writeMessage("\nconnection closed");
  }
}