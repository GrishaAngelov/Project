package com.clouway.networking.clientservercommunication;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface DisplayOperation {

  void writeMessage(String message);

  void clearDisplay();

}
