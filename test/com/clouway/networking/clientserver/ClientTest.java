package com.clouway.networking.clientserver;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientTest {
  private Client client;
  private SimpleServer server;

  @Before
  public void setUp() {
    server = new SimpleServer(1580);
    new Thread(new Runnable() {
      @Override
      public void run() {
        server.runServer();
      }
    }).start();
    client = new Client(1580);
  }

  @Test
  public void clientReceiveData() throws ClassNotFoundException, IOException {
    client.runClient();
    assertEquals("ServerMessage", client.getData());
  }

  class SimpleServer {
    private int port;
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    SimpleServer(int port) {
      this.port = port;
    }

    public void runServer() {
      try {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject("ServerMessage");
        objectOutputStream.flush();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          objectOutputStream.close();
          socket.close();
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
