package com.clouway.networking.clientserver;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientTest {
  private int PORT = 1580;
  private String HOST = "127.0.0.1";
  private Client client;
  private ServerApplication server;
  private MockClientDisplay clientDisplay = new MockClientDisplay();

  @Before
  public void setUp() {
    server = new ServerApplication(PORT);
    client = new Client(HOST, PORT, clientDisplay);
  }

  @Test
  public void clientShouldReceiveDataWhenConnectToServer() throws ClassNotFoundException, IOException {
    startServer();
    startClient();
    assertTrue(client.getData().startsWith("received: "));
    assertEquals("\nconnection closed", clientDisplay.msg);
  }

  class ServerApplication {
    private int port;
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    ServerApplication(int port) {
      this.port = port;
    }

    public void runServer() {
      try {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject("received: "+new Date().toString());
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

  private void startServer() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        server.runServer();
      }
    }).start();
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  class MockClientDisplay implements Display {
    private String msg;

    public boolean isClosed = false;

    @Override
    public void show() {
    }

    @Override
    public void writeMessage(String msg) {
      this.msg = msg;
    }

    @Override
    public void close() {
      isClosed = true;
    }

    @Override
    public void addListener(StopServerListener listener) {
    }
  }

  private void startClient() throws ClassNotFoundException, IOException {
    client.connect();
  }
}
