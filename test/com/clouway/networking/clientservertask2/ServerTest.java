package com.clouway.networking.clientservertask2;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Calendar;
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
  private MockDisplay serverDisplay = new MockDisplay();
  private MockDisplay clientDisplay = new MockDisplay();
  private DateProvider dateProvider;

  @Before
  public void setUp() throws IOException {
    dateProvider = new DateProvider() {
      @Override
      public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.YEAR, 2012);
        return calendar.getTime().toString();
      }
    };
    server = new Server(1580, dateProvider, serverDisplay);
    client = new ClientApplication(HOST, PORT, clientDisplay);
  }

  @After
  public void tearDown() throws IOException {
    stopServer();
  }

  @Test
  public void serverShouldRespondWhenClientIsConnected() throws ClassNotFoundException, IOException, InterruptedException {
    runServer();
    connectClient();
    Thread.sleep(50);
    assertEquals("\ndata sent", serverDisplay.msg);
    assertEquals("connection closed", clientDisplay.msg);
  }

  @Test
  public void serverShouldCloseUiWhenServerIsStopped() throws ClassNotFoundException, IOException {
    server.runServer();
    server.stopServer();
    assertTrue(serverDisplay.isClosed);
  }

  @Test
  public void displayControllerShouldStopTheServer() throws IOException, ClassNotFoundException, InterruptedException {
    runServer();
    connectClient();
    serverDisplay.stopServerListener.onStopServer();
    assertTrue(serverDisplay.isClosed);
    connectClient();
  }

  private void stopServer() throws IOException {
    server.stopServer();
  }

  private class MockDisplay implements DisplayController {
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
  }

  private void connectClient() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(10);
          client.connect();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
      }
    }).start();
  }


}
