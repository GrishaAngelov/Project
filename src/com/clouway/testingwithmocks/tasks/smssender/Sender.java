package com.clouway.testingwithmocks.tasks.smssender;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Sender {
  private Sms sms;
  private SmsGateway smsGateway;

  public Sender(Sms sms, SmsGateway smsGateway) {
    this.sms = sms;
    this.smsGateway = smsGateway;
  }

  private boolean isReceiverCorrect() {
    if (sms.getReceiver().length() < 1 || sms.getReceiver().length() > 10) {
      return false;
    }
    return true;
  }

  private boolean isTitleCorrect() {
    if (sms.getTitle().length() < 0) {
      return false;
    }
    return true;
  }

  private boolean isMessageTextCorrect() {
    if (sms.getMessageText().length() > 0 && sms.getMessageText().length() < 120) {
      return true;
    }
    return false;
  }

  public String sendMessage(Sms sms) {
    if (isReceiverCorrect() && isTitleCorrect() && isMessageTextCorrect()) {
      return smsGateway.sendSms(sms);
    } else {
      smsGateway.sendSms(sms);
      throw new IncompleteSmsComponentsException();
    }
  }
}
