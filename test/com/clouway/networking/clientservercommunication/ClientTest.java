package com.clouway.networking.clientservercommunication;

import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    server = new ServerApplication(PORT, new Clock() {
      @Override
      public Date currentDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.YEAR, 2012);
        return calendar.getTime();
      }
    });
    client = new Client(HOST, PORT, clientDisplay);
  }

  @Test(expected = ComparisonFailure.class)
  public void clientShouldReceiveDataWhenConnectToServer() throws ClassNotFoundException, IOException, ParseException, InterruptedException {
    startServer();
    client.connect();
    Thread.sleep(20);
    assertEquals(new Clock().currentDate().toString(), client.getData());
    assertEquals("\nconnection closed", clientDisplay.message);
  }

  class Clock {
    public Date currentDate() {
      return new Date();
    }
  }

  class ServerApplication {
    private int port;
    private Clock clock;
    private Date date;
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter writer;

    ServerApplication(int port, Clock clock) {
      this.port = port;
      this.clock = clock;
    }

    public void runServer() {
      try {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        writer.write(simpleDateFormat.format(clock.currentDate()));
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
    public void addListener(ConnectListener connectListener) {

    }
  }

  private void startClient() throws ClassNotFoundException, IOException {
    client.connect();
  }
}
