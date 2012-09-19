package com.clouway.networking.clientservertask2;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerDisplayNotifier {

  public String notifyWaitingForConnection(){
    return "\nwaiting";
  }

  public String notifyForConnectedClient(){
    return "\nconnected";
  }
}
