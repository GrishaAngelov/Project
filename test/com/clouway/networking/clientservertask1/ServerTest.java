package com.clouway.networking.clientservertask1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerTest {
  // server accept client connection and server display(s) show message about that
  // server send data to connected client

  private final int PORT = 1580;
  private final String HOST = "localhost";
  private UI mockUI;
  private Socket socket;

  @Before
  public void setUp() throws IOException, InterruptedException {
    mockUI = mock(UI.class);
    List<UI> uiList = new ArrayList<UI>();
    uiList.add(mockUI);

    DateProvider dateProvider = new DateProvider() {
      @Override
      public Date provideCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, Calendar.MAY, 10);
        return calendar.getTime();
      }
    };

    Server server = new Server(uiList, dateProvider);
    server.runServer(PORT);
    Thread.sleep(50);
    socket = new Socket(HOST, PORT);
  }

  @Test
  public void serverDisplayMessageAboutAcceptedClientConnection() throws IOException, InterruptedException {
    Thread.sleep(50);
    verify(mockUI).displayMessage("\nconnected client");
  }

  @Test(expected = AssertionError.class)
  public void serverSendDataToConnectedClient() throws Exception {
    final String[] data = new String[1];
    connectedClientReadDataFromServer(data);
    assertThat(new DateProvider().provideCurrentDate().toString(), is(data[0]));
  }

  private void connectedClientReadDataFromServer(final String[] data) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Scanner scanner = new Scanner(socket.getInputStream());
          data[0] = scanner.nextLine();
        } catch (IOException e) {
        }
      }
    }).start();
  }
}
