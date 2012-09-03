package com.clouway.networking.multiclientserver;

/**
* @author Grisha Angelov <grisha.angelov@clouway.com>
*/

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ServerTest {

  private Server server;
  private ClientApplication clientApplication;
  private int PORT = 1590;
  private String HOST = "localhost";
  private MockClientDisplay clientDisplay = new MockClientDisplay();
  private MockServerDisplay serverDisplay = new MockServerDisplay();

  @Before
  public void setUp() throws InterruptedException {
    server = new Server(PORT,serverDisplay);
    new Thread(new Runnable() {
      @Override
      public void run() {
        server.runServer();
      }
    }).start();

    clientApplication = new ClientApplication(HOST,PORT,clientDisplay);
  }

  @After
  public void tearDown() throws InterruptedException {
    server.stopServer();
  }

  @Test
  public void serverShouldRespondToClientWhenClientConnect() throws IOException, ClassNotFoundException, InterruptedException {
    clientApplication.connect();
    assertEquals("\nconnected", clientDisplay.msg);
  }

  @Test
  public void serverShouldCloseUiWhenStopButtonIsPressed() throws ClassNotFoundException, IOException, InterruptedException {
    clientApplication.connect();
    server.stopServer();
    serverDisplay.stopServerListener.onStopServer();
    assertEquals(true, serverDisplay.isClosed);
  }


  class MockClientDisplay implements ClientDisplay{
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
    public void addListener(ConnectServerListener listener) {
    }
  }

  class MockServerDisplay implements ServerDisplay{
    boolean isClosed = false;
    StopServerListener stopServerListener;

    @Override
    public void show() {

    }

    @Override
    public void writeMessage(String msg) {

    }

    @Override
    public void close() {
      isClosed = true;
    }

    @Override
    public void addListener(StopServerListener listener) {
       stopServerListener = listener;
    }
  }

  class ClientApplication {

    private int port;
    private String host;
    private ClientDisplay clientDisplay;
    private Socket socket;
    private ObjectInputStream inputStream;


    public ClientApplication(String host, int port, ClientDisplay display) {
      this.host = host;
      this.port = port;
      this.clientDisplay = display;
    }

    public void connect() throws IOException, ClassNotFoundException, InterruptedException {
      clientDisplay.writeMessage("connecting");
      socket = new Socket(host, port);
      clientDisplay.writeMessage("\nconnected");
      inputStream = new ObjectInputStream(socket.getInputStream());
      inputStream.readObject().toString();
      closeConnection();
    }

    private void closeConnection() {
      try {
        inputStream.close();
        socket.close();
//        clientDisplay.writeMessage("connection is closed");
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}