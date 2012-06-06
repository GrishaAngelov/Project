package com.clouway.testingwithmocks.greetingjmockexample;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Greeting {
  private GreetingManager greetingManager;

  public Greeting(GreetingManager greetingManager) {
    this.greetingManager = greetingManager;
  }

  public void setGreeting(String message) {
    greetingManager.createGreet(message);
  }

  public String getMyGreeting() {
    return greetingManager.sayGreet();
  }
}
