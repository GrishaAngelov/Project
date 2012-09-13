package com.clouway.networking.clientservertask1;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  /**
   * This Server class is responsible for providing current date and time to only one client at time.
   */


  private int port;
  private DisplayController displayController;
  private ServerSocket serverSocket;
  private Socket socket;
  private PrintWriter writer;
  private DateProvider dateProvider;

  /**
   * Constructor takes as parameters specified port number and display, which contains
   * ui of the server.In that way we can separate the ui from the logic;
   *
   * @param port
   * @param displayController
   */
  public Server(int port, DateProvider dateProvider, DisplayController displayController) {
    this.port = port;
    this.displayController = displayController;
    this.dateProvider = dateProvider;

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
    writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    writer.write(dateProvider.getCurrentDate());
    writer.flush();
    writer.close();
    displayController.writeMessage("\ndata sent");
  }

  public void stopServer() {
    try {
      if (socket != null) {
        writer.close();
        serverSocket.close();
        socket.close();
        displayController.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
