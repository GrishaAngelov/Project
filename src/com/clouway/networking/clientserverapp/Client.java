package com.clouway.networking.clientserverapp;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

  private int port;
  private String host;
  private DisplayController clientDisplay;
  private Socket socket;
  private ObjectInputStream objectInputStream;
  private String data;

  /**
   * Takes as parameter specified port number for connection to server
   *
   * @param port - used port by the server
   */
  public Client(String host, int port, DisplayController display) {
    this.host = host;
    this.port = port;
    this.clientDisplay = display;
    display.addListener(new ConnectListener() {
      @Override
      public void onConnect() {
        try {
          connect();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
    });
  }


  /**
   * Starts the client application
   *
   * @throws java.io.IOException if an I/O error occurs when creating the socket.
   * @throws ClassNotFoundException when class of a serialized object cannot
   * be found.
   */
  public void connect() throws IOException, ClassNotFoundException {
    try {
      clientDisplay.clearDisplay();
      socket = new Socket(host, port);
      clientDisplay.writeMessage("connecting...");
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      clientDisplay.writeMessage("\nconnected");
      data = objectInputStream.readObject().toString();
      clientDisplay.writeMessage("\nreceived: "+data);
    } finally {
        stopClient();
    }
  }

  public String getData(){
    return data;
  }

  public void stopClient() throws IOException {
    if(socket!=null){
      objectInputStream.close();
      socket.close();
      clientDisplay.writeMessage("\nconnection closed");
    }
  }
}