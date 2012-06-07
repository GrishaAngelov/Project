package com.clouway.testingwithmocks.tasks.smssender;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Sms {
  private String receiver;
  private String title;
  private String messageText;

  public Sms(String receiver, String title, String messageText) {
    this.receiver = receiver;
    this.title = title;
    this.messageText = messageText;
  }

  public String getReceiver() {
    return receiver;
  }

  public String getTitle() {
    return title;
  }

  public String getMessageText() {
    return messageText;
  }
}
