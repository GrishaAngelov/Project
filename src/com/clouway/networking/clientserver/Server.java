package com.clouway.networking.clientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

  /**
   * This Server class is responsible for providing current date and time to only one client at time.
   */


  private int port;
  private Display display;
  private ServerSocket serverSocket;
  private Socket socket;
  private ObjectOutputStream objectOutputStream;

  /**
   * Constructor takes as parameters specified port number and display, which contains
   * ui of the server.In that way we can separate the ui from the logic;
   *
   * @param port
   * @param display
   */
  public Server(int port, Display display) {
    this.port = port;
    this.display = display;

    display.addListener(new StopServerListener() {
      @Override
      public void onStopServer() {
        stopServer();
      }
    });
  }

  /**
   * Run the server application
   *
   * @throws IOException
   */
  public void runServer() throws IOException {
    serverSocket = new ServerSocket(port);
    display.writeMessage("waiting...");
    socket = serverSocket.accept();
    display.writeMessage("\nconnected");
    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    objectOutputStream.writeObject("\nreceived: "+new Date().toString());
    objectOutputStream.flush();
    display.writeMessage("\ndata sent");
  }

  public void stopServer() {
    try {
      objectOutputStream.close();
      serverSocket.close();
      socket.close();
      display.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
