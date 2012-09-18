package com.clouway.networking.clientservertask2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerTest {
  private Server server;
  private List<UI> displayList;
  private List<Socket> clientList = new ArrayList<Socket>();
  final private int PORT = 1850;
  final String HOST = "127.0.0.1";

  @Before
  public void setUp() throws IOException {
    displayList = new ArrayList<UI>();
    server = new Server(displayList);
    server.runServer(PORT);
  }

  @After
  public void tearDown() throws IOException, InterruptedException {
    server.closeServer();
    Thread.sleep(10);
  }

  @Test
  public void serverDisplayMessageAboutAcceptedClientConnection() throws IOException, InterruptedException {
    UI ui = mock(UI.class);
    displayList.add(ui);
    new Socket("localhost", PORT);
    Thread.sleep(50);
    verify(ui, times(1)).displayMessage("\nconnected");
  }

  @Test
  public void serverSendMessageToFirstClientThatHeIsFirst() throws IOException, InterruptedException {
    createClients(1);
    assertServerResponsesToConnectedClientWith("You are " + clientList.size(), clientList.get(0));
  }

  @Test
  public void serverSendMessageToSecondClientThatHeIsSecond() throws IOException, InterruptedException {
    createClients(2);
    assertServerResponsesToConnectedClientWith("You are " + clientList.size(), clientList.get(1));
  }

  @Test
  public void
  serverSendMessageToFirstClientThatSecondClientHasConnected() throws Exception {
    createClients(2);
    assertServerResponsesToConnectedClientWith("Connected clients: "+ clientList.size(), clientList.get(0));
  }

  @Test
  public void serverSendNotificationToFirstTwoClients() throws Exception {
    createClients(3);
    assertServerResponsesToConnectedClientWith("Connected clients: "+ clientList.size(), clientList.get(0));
    assertServerResponsesToConnectedClientWith("Connected clients: "+ clientList.size(), clientList.get(1));
  }

  private void createClients(int numberOfClients) throws IOException, InterruptedException {

    for (int i = 0; i < numberOfClients; i++) {

      Thread.sleep(50);
      Socket socket = new Socket(HOST, PORT);

      clientList.add(socket);

    }
  }

  private void assertServerResponsesToConnectedClientWith(String expectedResponse, Socket connectedClient) throws IOException, InterruptedException {
    StringBuilder stringBuilder = new StringBuilder();
    readDataFromServer(connectedClient, stringBuilder);
    assertThat(stringBuilder.toString(), is(expectedResponse));
  }

  private void readDataFromServer(final Socket clientSocket, final StringBuilder builder) throws IOException, InterruptedException {

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          while (true) {
            InputStream inputStream = clientSocket.getInputStream();

            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {
              builder.delete(0, builder.length());
              builder.append(scanner.nextLine());
            }
          }
        } catch (IOException e) {
        }
      }
    }).start();
    Thread.sleep(50);
  }
}
