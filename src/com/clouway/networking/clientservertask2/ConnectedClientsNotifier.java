package com.clouway.networking.clientservertask2;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ConnectedClientsNotifier {

  public String notifyForNewConnection() {
    return "Connected clients: ";
  }

  public String notifyForClientDisconnection() {
    return "Client has disconnected\nClients left: ";
  }

  public String notifyConnectedClientForHisCounter() {
    return "You are ";
  }

}
