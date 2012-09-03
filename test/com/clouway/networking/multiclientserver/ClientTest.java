package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ClientTest {

  private Client client;
  private ServerApplication serverApplication;
  private int PORT = 1580;
  private String HOST = "localhost";
  private MockSwingClientDisplay clientDisplay = new MockSwingClientDisplay();
  private MockServerDisplay serverDisplay = new MockServerDisplay();

  @Before
  public void setUp() throws InterruptedException {
    serverApplication = new ServerApplication(PORT, serverDisplay);
    new Thread(serverApplication).start();
    Thread.sleep(20);
    client = new Client(HOST, PORT, clientDisplay);
  }

  @Test
  public void clientShouldReceiveDataWhenConnectToServer() throws IOException, ClassNotFoundException {
    client.connect();
    assertTrue(client.getData().startsWith("\nreceived: "));
  }

  @Test
  public void clientShouldCloseConnectionWhenServerCloseConnection() throws IOException, ClassNotFoundException {
    client.connect();
    serverApplication.stopServer();
    assertEquals("\nconnection is closed by server", clientDisplay.msg);
  }

  @Test
  public void clientTryToConnectToShutdownServer() throws IOException, ClassNotFoundException {
    serverApplication.stopServer();
    client.connect();
    assertEquals("\nconnection is closed by server", clientDisplay.msg);
  }

  class MockSwingClientDisplay implements ClientDisplay {
    String msg;
    boolean isClosed = false;

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
    public void addListener(ConnectServerListener listener) {
    }
  }

  class MockServerDisplay implements ServerDisplay {
    String msg;

    @Override
    public void show() {
    }

    @Override
    public void writeMessage(String msg) {
      this.msg = msg;
    }

    @Override
    public void close() {
    }

    @Override
    public void addListener(StopServerListener listener) {
    }
  }

  class ServerApplication implements Runnable {

    private ServerDisplay serverDisplay;
    private int port;
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private boolean stop = false;

    public ServerApplication(int port, ServerDisplay serverDisplay) {
      this.port = port;
      this.serverDisplay = serverDisplay;
    }

    @Override
    public void run() {
      try {
        serverSocket = new ServerSocket(port);

        while (!stop) {
          serverDisplay.writeMessage("waiting");
          socket = serverSocket.accept();
          serverDisplay.writeMessage("\nconnected");
          objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
          objectOutputStream.writeObject("\nreceived: " + new Date().toString());
          objectOutputStream.flush();
          serverDisplay.writeMessage("\ndata sent");
          stopServer();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    public void stopServer() {
      try {
        if (objectOutputStream != null) {
          objectOutputStream.close();
          socket.close();
          serverSocket.close();
        }
        stop = true;
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}