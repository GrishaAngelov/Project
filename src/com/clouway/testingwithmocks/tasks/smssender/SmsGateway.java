package com.clouway.testingwithmocks.tasks.smssender;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface SmsGateway {
  String sendSms(Sms message);
}
