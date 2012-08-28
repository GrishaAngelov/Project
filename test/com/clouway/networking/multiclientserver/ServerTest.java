package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ServerTest {

  private Server server;
  private SimpleClient client;

  @Before
  public void setUp() {
    server = new Server(1590);
    new Thread(server).start();
    client = new SimpleClient(1590);
  }

  @Test
  public void serverRespondToClient() throws IOException, ClassNotFoundException {
    client.runClient();
    assertEquals("\nyou are: 1", client.getData());
  }

  class SimpleClient {

    private int port;
    private String data;
    private Socket socket;
    private ObjectInputStream inputStream;

    public SimpleClient(int port) {
      this.port = port;
    }

    public void runClient() throws IOException, ClassNotFoundException {
      socket = new Socket("127.0.0.1", port);
      inputStream = new ObjectInputStream(socket.getInputStream());
      data = inputStream.readObject().toString();
      closeConnection();
    }

    public String getData() {
      return data;
    }

    private void closeConnection() {
      try {
        inputStream.close();
        socket.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}