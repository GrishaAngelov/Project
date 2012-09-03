package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

  private int port;
  private String host;
  private ClientDisplay clientDisplay;
  private Socket socket;
  private ObjectInputStream objectInputStream;
  private String data;
  private boolean stop = false;

  /**
   * Takes as parameter specified port number for connection to server
   *
   * @param port - used port by the server
   */
  public Client(String host, int port, ClientDisplay serverDisplay) {
    this.host = host;
    this.port = port;
    this.clientDisplay = serverDisplay;
    clientDisplay.addListener(new ConnectServerListener() {
      @Override
      public void onConnect() {
        new Thread(new Runnable() {
          @Override
          public void run() {
            try {
              try {
                connect();
              } catch (IOException e) {
                e.printStackTrace();
              }
            } catch (ClassNotFoundException e) {
              e.printStackTrace();
            }
          }
        }).start();

      }
    });
  }

  /**
   * Connect the client to server
   *
   * @throws IOException            if an I/O error occurs when creating the socket.
   * @throws ClassNotFoundException when class of a serialized object cannot be found.
   */
  public void connect() throws ClassNotFoundException, IOException {
    try {
      socket = new Socket(host, port);
      clientDisplay.writeMessage("connecting...");
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      clientDisplay.writeMessage("\nconnected");
      while (!stop) {
        data = (String) objectInputStream.readObject();
        clientDisplay.writeMessage(data);
      }
    } catch (IOException ex) {
      stop = true;
      objectInputStream.close();
      socket.close();
      clientDisplay.writeMessage("\nconnection is closed by server");
    }
  }

  public String getData() {
    return data;
  }
}
