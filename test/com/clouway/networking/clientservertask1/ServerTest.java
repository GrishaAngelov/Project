package com.clouway.networking.clientservertask1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerTest {

  private int PORT = 1580;
  private String HOST = "127.0.0.1";
  private Server server;
  private ClientApplication client;
  private MockServerDisplay serverDisplay = new MockServerDisplay();
  private MockServerDisplay clientDisplay = new MockServerDisplay();

  @Before
  public void setUp() throws IOException {
    DateProvider dateProvider = new DateProvider();
    server = new Server(PORT,dateProvider, serverDisplay);
    client = new ClientApplication(HOST, PORT, clientDisplay);
  }

  @After
  public void tearDown() {
    stopServer();
  }

  @Test
  public void serverShouldRespondWhenClientIsConnected() throws ClassNotFoundException, IOException {
    runServer();
    connectClientToServer();
    assertEquals("\ndata sent", serverDisplay.msg);
    assertEquals("connection closed", clientDisplay.msg);
  }

  @Test
  public void serverShouldCloseUiWhenServerIsStopped() throws ClassNotFoundException, IOException {
    runServer();
    connectClientToServer();
    stopServer();
    assertTrue(serverDisplay.isClosed);
  }

  @Test(expected = SocketException.class)
  public void displayControllerShouldStopTheServer() throws IOException, ClassNotFoundException, InterruptedException {
    runServer();
    connectClientToServer();
    serverDisplay.stopServerListener.onStopServer();
    assertTrue(serverDisplay.isClosed);
    connectClientToServer();
  }

  @Test
  public void stopNotStartedServer(){
    server.stopServer();
  }

  private void runServer() {
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
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void stopServer() {
    server.stopServer();
  }

  private class MockServerDisplay implements DisplayController {
    private String msg;
    private boolean isClosed = false;

    public StopServerListener stopServerListener;

    @Override
    public void writeMessage(String msg) {

      this.msg = msg;
    }

    @Override
    public void clearDisplay() {
    }

    @Override
    public void close() {
      isClosed = true;
    }

    @Override
    public void addListener(StopServerListener stopServerListener) {
      this.stopServerListener = stopServerListener;
    }


    @Override
    public void addListener(ConnectionListener connectionListener) {

    }
  }

  class ClientApplication {
    private int port;
    private String host;
    private String data;
    private Socket socket;
    private Scanner scanner;

    private DisplayController displayController;

    ClientApplication(String host, int port, DisplayController displayController) {
      this.host = host;
      this.port = port;
      this.displayController = displayController;
    }

    public void connect() throws IOException, ClassNotFoundException {
      try {
        socket = new Socket(host, port);
        displayController.writeMessage("\nconnecting...");
        scanner = new Scanner(new InputStreamReader(socket.getInputStream()));
        displayController.writeMessage("\nconnected");
        data = scanner.nextLine();
        displayController.writeMessage("\nreceived: " + data);
      } finally {
        scanner.close();
        socket.close();
        displayController.writeMessage("connection closed");
      }
    }

    public void close(){

    }
  }

  private void connectClientToServer() throws IOException, ClassNotFoundException {
    client.connect();
  }
}
