package com.clouway.networking.clientservertask1;

import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
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
    DateProvider dateProvider = new DateProvider(){
      @Override
      public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, 5);
        calendar.set(Calendar.YEAR, 2012);
        return calendar.getTime().toString();
      }
    };
    server = new ServerApplication(PORT, dateProvider);
    client = new Client(HOST, PORT, clientDisplay);
  }

  @Test (expected = ComparisonFailure.class)
  public void clientShouldReceiveDataWhenConnectToServer() throws ClassNotFoundException, IOException, ParseException {
    startServer();
    startClient();
    assertEquals(new DateProvider().getCurrentDate(),client.getData());
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
    private PrintWriter writer;
    private DateProvider dateProvider;

    ServerApplication(int port,DateProvider dateProvider) {
      this.port = port;
      this.dateProvider = dateProvider;
    }

    public void runServer() {
      try {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
//        Locale.setDefault(Locale.US);
//        writer.write(simpleDateFormat.parse("Wed Sep 05 12:42:57 EEST 2012").toString());
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

  private void startClient() throws ClassNotFoundException, IOException {
    client.connect();
  }
}
