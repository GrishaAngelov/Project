package com.clouway.networking.clientservertask2;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientTest {

  // client read data from server and display that data

  private final int PORT = 1580;
  private final String HOST = "localhost";

  @Test
  public void clientDisplayReadDataFromServer() throws IOException, InterruptedException {
    runServer(PORT);

    UI mockUI = mock(UI.class);
    Client client = new Client(mockUI);
    client.connect(HOST, PORT);

    verify(mockUI).displayMessage("\nserver message");
    verify(mockUI).displayMessage("\nconnection is closed");
  }


  public void runServer(final int port) throws IOException {
    final ServerSocket serverSocket = new ServerSocket(port);
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Socket socket = serverSocket.accept();
          PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
          printWriter.println("server message");
          printWriter.flush();

          printWriter.close();
          socket.close();
          serverSocket.close();

        } catch (IOException e) {
        }
      }
    }).start();
  }
}

