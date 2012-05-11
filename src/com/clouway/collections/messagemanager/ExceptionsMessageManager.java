package com.clouway.collections.messagemanager;

import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExceptionsMessageManager {

  private Hashtable<String, String> table;

  /**
   * Constructor that initialize table with predefined combinations (messageCode,message)
   */
  public ExceptionsMessageManager() {
    table = new Hashtable();
    table.put("1", "Incorrect PIN!");
    table.put("2", "Incorrect ID!");
    table.put("3", "Incorrect Post Code!");
  }

  /**
   * Method adds the combination (messageCode,message) if it does not exist
   *
   * @param messageCode - code of the message
   * @param message     - message content
   */
  public void registerErrorMessage(String messageCode, String message) {
    if (!(table.containsKey(messageCode) && table.containsValue(message))) {
      table.put(messageCode, message);
      System.out.printf("Successfully added (%s,%s)\n", messageCode, message);
    } else {
      throw new DuplicateCombinationException();
    }
  }

  /**
   * Method checks whether messageCode is already in the table
   *
   * @param messageCode
   * @return the message corresponding to messageCode
   */
  public String raiseError(String messageCode) {
    if (table.containsKey(messageCode)) {
      return table.get(messageCode);
    } else {
      throw new KeyNotFoundException();
    }
  }

  /**
   * Method returns all messages as string
   *
   * @return string containing all messages
   */
  public String getErrorMessages() {
    String allMessages = "";
    for (String item : table.values()) {
      allMessages += item + "\n";
    }
    return allMessages;
  }
}
