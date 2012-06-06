package com.clouway.testingwithmocks.abstractsystemjmockexample;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AbstractSystemUser {
  private AbstractSystem abstractSystem;

  public AbstractSystemUser(AbstractSystem abstractSystem){
    this.abstractSystem = abstractSystem;
  }

  public String turnOn(){
    return abstractSystem.turnOnSystem();
  }

  public String doMainThing(){
    return abstractSystem.doMainSystemActivity();
  }

  public String turnOff(){
    return abstractSystem.turnOffSystem();
  }
}
