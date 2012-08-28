package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

  private Client client;
  private SimpleServer server;

  @Before
  public void setUp() {
    server = new SimpleServer(1580);
    new Thread(server).start();
    client = new Client(1580);
  }


  @Test
  public void clientReceiveDataFromServer() {
    client.runClient();
    assertEquals("HELLO I AM SERVER", client.getData());
  }

  class SimpleServer implements Runnable {

    private int port;
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private boolean stop = false;

    public SimpleServer(int port) {
      this.port = port;
    }

    @Override
    public void run() {
      try {
        serverSocket = new ServerSocket(port);

        while (!stop) {
          socket = serverSocket.accept();
          objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
          objectOutputStream.writeObject("HELLO I AM SERVER");
          objectOutputStream.flush();
          closeConnection();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    public void closeConnection() {
      try {
        objectOutputStream.close();
        socket.close();
        serverSocket.close();
        stop = true;
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}