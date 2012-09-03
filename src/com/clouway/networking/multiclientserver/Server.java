package com.clouway.networking.multiclientserver;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class Server {

  private int port;
  private ServerDisplay serverDisplay;
  private ServerSocket serverSocket;
  private Socket socket;
  private ObjectOutputStream objectOutputStream;
  private int currentClientNumber = 0;
  private boolean stop = false;
  private Map<Socket, ObjectOutputStream> clients = new Hashtable<Socket, ObjectOutputStream>();

  /**
   * Constructor takes as parameter specified port number and display
   *
   * @param port
   * @param display
   */
  public Server(int port, ServerDisplay display) {
    this.port = port;
    this.serverDisplay = display;
    display.addListener(new StopServerListener() {
      @Override
      public void onStopServer() {
       stopServer();
      }
    });
  }

  /**
   * Run the server
   */
  public void runServer() {
    try {
      serverSocket = new ServerSocket(port);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    while (!stop) {
      try {
        serverDisplay.writeMessage("\nwaiting for client...");
        socket = serverSocket.accept();

        currentClientNumber++;
        serverDisplay.writeMessage("\nconnected");

        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        clients.put(socket, objectOutputStream);
        objectOutputStream.writeObject("\nyou are: " + currentClientNumber);
        objectOutputStream.flush();

        new Thread(new Notificator(socket, clients)).start();

        objectOutputStream.writeObject("\nreceived: " + new Date().toString());
        objectOutputStream.flush();
        serverDisplay.writeMessage("\ndata sent\n");
      } catch (IOException ex) {
        serverDisplay.writeMessage("\nconnection is closed");

      }
    }
  }

  public void stopServer(){
    stop = true;
    serverDisplay.close();
    try {
     if(objectOutputStream!=null){
       objectOutputStream.close();
       socket.close();
       serverSocket.close();
     }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}