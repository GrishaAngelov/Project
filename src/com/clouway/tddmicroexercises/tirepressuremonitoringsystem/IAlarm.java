package com.clouway.tddmicroexercises.tirepressuremonitoringsystem;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface IAlarm {
  public void check();

  public boolean isAlarmOn();
}
