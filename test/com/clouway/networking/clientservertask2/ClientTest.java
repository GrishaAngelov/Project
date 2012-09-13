package com.clouway.networking.clientservertask2;

import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

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
    server = new ServerApplication(PORT, new DateProvider() {
      @Override
      public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.YEAR, 2012);
        return calendar.getTime().toString();
      }

    });
    client = new Client(HOST, PORT, clientDisplay);
  }

  @Test(expected = ComparisonFailure.class)
  public void clientShouldReceiveDataWhenConnectToServer() throws ClassNotFoundException, IOException, InterruptedException {
    startServer();
    client.connect();
    Thread.sleep(20);
//    System.out.println(client.getData());
//    System.out.println(new DateProvider().getCurrentDate());
    assertEquals(new DateProvider().getCurrentDate(), client.getData());
    Thread.sleep(20);
    assertEquals("\nconnection closed", clientDisplay.message);
  }

  class ServerApplication {
    private int port;
    private DateProvider dateProvider;
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter writer;

    ServerApplication(int port, DateProvider dateProvider) {
      this.port = port;
      this.dateProvider = dateProvider;
    }

    public void runServer() {
      try {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(dateProvider.getCurrentDate());
        writer.flush();
        stopServer();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void stopServer() {
      try {
        writer.close();
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
    public void addListener(ConnectionListener connectionListener) {

    }
  }
}
