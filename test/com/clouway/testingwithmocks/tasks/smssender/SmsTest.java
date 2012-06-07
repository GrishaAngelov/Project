package com.clouway.testingwithmocks.tasks.smssender;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
@RunWith(JMock.class)
public class SmsTest {
  private Mockery context = new JUnit4Mockery();
  private SmsGateway smsGateway = context.mock(SmsGateway.class);
  private Sender sender;

  @Test
  public void testSendCorrectSms() {
    final Sms message = new Sms("0883212789", "Meeting", "Tomorrow at 10 a.m.");
    sender = new Sender(message, smsGateway);
    context.checking(new Expectations() {{
      oneOf(smsGateway).sendSms(message);
      will(returnValue("Message is sent!"));
    }});
    assertEquals("Message is sent!", sender.sendMessage(message));
  }

  @Test(expected = IncompleteSmsComponentsException.class)
  public void testSendSmsWithTooShortReceiver() {
    final Sms incorrectReceiverSms = new Sms("0885", "Greeting", "Hello");
    sender = new Sender(incorrectReceiverSms, smsGateway);
    context.checking(new Expectations() {{
      oneOf(smsGateway).sendSms(incorrectReceiverSms);
      will(returnValue("Message is not sent!"));
      will(throwException(new IncompleteSmsComponentsException()));
    }});
    assertEquals("Message is not sent!", sender.sendMessage(incorrectReceiverSms));
  }

  @Test(expected = IncompleteSmsComponentsException.class)
  public void testSendSmsWithTooLongReceiver() {
    final Sms incorrectReceiverSms = new Sms("12345678910", "Greeting", "Hello");
    sender = new Sender(incorrectReceiverSms, smsGateway);
    context.checking(new Expectations() {{
      oneOf(smsGateway).sendSms(incorrectReceiverSms);
      will(returnValue("Message is not sent!"));
      will(throwException(new IncompleteSmsComponentsException()));
    }});
    assertEquals("Message is not sent!", sender.sendMessage(incorrectReceiverSms));
  }

  @Test(expected = IncompleteSmsComponentsException.class)
  public void testSendSmsWithEmptyTitle() {
    final Sms incorrectTitleSms = new Sms("0883212789", "", "Hello");
    sender = new Sender(incorrectTitleSms, smsGateway);
    context.checking(new Expectations() {{
      oneOf(smsGateway).sendSms(incorrectTitleSms);
      will(returnValue("Message is not sent!"));
      will(throwException(new IncompleteSmsComponentsException()));
    }});
    assertEquals("Message is not sent!", sender.sendMessage(incorrectTitleSms));
  }

  @Test(expected = IncompleteSmsComponentsException.class)
  public void testSendSmsWithEmptyMessageText() {
    final Sms incorrectMessageTextSms = new Sms("0883812789", "Meeting", "");
    sender = new Sender(incorrectMessageTextSms, smsGateway);
    context.checking(new Expectations() {{
      oneOf(smsGateway).sendSms(incorrectMessageTextSms);
      will(returnValue("Message is not sent!"));
      will(throwException(new IncompleteSmsComponentsException()));
    }});
    assertEquals("Message is not sent!", sender.sendMessage(incorrectMessageTextSms));
  }

  @Test(expected = IncompleteSmsComponentsException.class)
  public void testSendSmsWithTooLongMessageText() {
    String tooLongText = "Short Message Service (SMS) is a text messaging service component of phone, web, or mobile communication systems, using standardized communications protocols that allow the exchange of short text messages between fixed line or mobile phone devices.\n" +
            "SMS text messaging is the most widely used data application in the world, with over 3.7 billion active users,[1] or 74% of all mobile phone subscribers.[citation needed] The term SMS is used as a synonym for all types of short text messaging as well as the user activity itself in many parts of the world.\n";
    final Sms incorrectMessageTextSms = new Sms("0883212789", "Title", tooLongText);
    sender = new Sender(incorrectMessageTextSms, smsGateway);
    context.checking(new Expectations() {{
      oneOf(smsGateway).sendSms(incorrectMessageTextSms);
      will(returnValue("Message is not sent!"));
      will(throwException(new IncompleteSmsComponentsException()));
    }});
    assertEquals("Message is not sent!", sender.sendMessage(incorrectMessageTextSms));
  }
}
