package com.clouway.networking.clientserverapp;

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
  private DisplayController displayController;
  private ServerSocket serverSocket;
  private Socket socket;
  private ObjectOutputStream objectOutputStream;

  /**
   * Constructor takes as parameters specified port number and display, which contains
   * ui of the server.In that way we can separate the ui from the logic;
   *
   * @param port
   * @param displayController
   */
  public Server(int port, DisplayController displayController) {
    this.port = port;
    this.displayController = displayController;

    displayController.addListener(new StopServerListener() {
      @Override
      public void onStopServer() {
        stopServer();
      }
    });
  }

  /**
   * Run the server application
   *
   * @throws java.io.IOException
   */
  public void runServer() throws IOException {
    serverSocket = new ServerSocket(port);
    displayController.writeMessage("waiting...");
    socket = serverSocket.accept();
    displayController.writeMessage("\nconnected");
    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    objectOutputStream.writeObject(new Date().toString());
    objectOutputStream.flush();
    displayController.writeMessage("\ndata sent");
  }

  public void stopServer() {
    try {
      if(socket!=null){
        objectOutputStream.close();
        serverSocket.close();
        socket.close();
        displayController.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
