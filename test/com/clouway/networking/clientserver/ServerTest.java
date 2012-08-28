package com.clouway.networking.clientserver;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerTest {
  private Server server;
  private SimpleClient client;

  @Before
  public void setUp() throws IOException {
    server = new Server(1580);
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          server.runServer();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();
    client = new SimpleClient(1580);
  }

  @Test
  public void serverRespondToClient() throws ClassNotFoundException, IOException {
    client.runClient();
    assertEquals("ServerMessage", client.getData());
  }

  class SimpleClient {
    private int port;
    private String data;
    private Socket socket;
    private ObjectInputStream objectInputStream;

    SimpleClient(int port) {
      this.port = port;
    }

    public void runClient() throws IOException, ClassNotFoundException {
      try {
        socket = new Socket("127.0.0.1", port);
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        data = (String) objectInputStream.readObject();
      } finally {
        objectInputStream.close();
        socket.close();
      }
    }

    public String getData() {
      return data;
    }
  }
}
