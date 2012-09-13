package com.clouway.networking.clientservertask1;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

  private int port;
  private String host;
  private DisplayController clientDisplay;
  private Socket socket;
  private BufferedReader reader;
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
    display.addListener(new ConnectionListener() {
      @Override
      public void onClientConnection() {
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
      clientDisplay.writeMessage("connecting...");
      socket = new Socket(host, port);
      reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      clientDisplay.writeMessage("\nconnected");
      data = reader.readLine();
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
      reader.close();
      socket.close();
      clientDisplay.writeMessage("\nconnection closed");
    }
  }
}