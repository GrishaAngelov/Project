package com.clouway.networking.clientserverapp;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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
  public void clientShouldReceiveDataWhenConnectToServer() throws ClassNotFoundException, IOException, ParseException {
    startServer();
    startClient();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
    simpleDateFormat.parse(client.getData());

    assertEquals("\nconnection closed", clientDisplay.message);
  }

  @Test(expected = ConnectException.class)
  public void clientTryToConnectToShutdownServer() throws IOException, ClassNotFoundException {
    startClient();
  }

  @Test
  public void clientTryToCloseConnectionThatIsNotOpen() throws IOException, ClassNotFoundException {
    client.stopClient();
  }

  @Test
  public void clientTryCloseConnectionTwice() throws IOException, ClassNotFoundException {
    startServer();
    startClient();

    client.stopClient();
    client.stopClient();
  }

  @Test(expected = ConnectException.class)
  public void startClientTwice() throws IOException, ClassNotFoundException {
    startServer();

    startClient();
    startClient();
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
        objectOutputStream.writeObject(new Date().toString());
        objectOutputStream.flush();
        stopServer();
      } catch (IOException e) {
        e.printStackTrace();

      }
    }

    public void stopServer() {
      try {
        objectOutputStream.close();
        socket.close();
        serverSocket.close();
      } catch (IOException e) {
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

  class MockClientDisplay implements DisplayController {
    private String message;

    public boolean isClosed = false;


    @Override
    public void writeMessage(String message) {
      this.message = message;
    }

    @Override
    public void clearDisplay() {

    }

    @Override
    public void close() {
      isClosed = true;
    }

    @Override
    public void addListener(StopServerListener listener) {
    }

    @Override
    public void addListener(ConnectListener connectListener) {

    }
  }

  private void startClient() throws ClassNotFoundException, IOException {
    client.connect();
  }
}
