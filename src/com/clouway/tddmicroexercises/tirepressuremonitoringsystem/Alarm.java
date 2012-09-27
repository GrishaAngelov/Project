package com.clouway.tddmicroexercises.tirepressuremonitoringsystem;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Alarm implements IAlarm {

  private ISensor sensor;
  private long alarmCount = 0;
  private boolean isAlarmOn = false;
  private PressureValueProvider pressureValueProvider = new PressureValueProvider();

  public void check() {
    double pressureValue = sensor.popNextPressurePsiValue();

    if (pressureValue < pressureValueProvider.provideLowPressureThreshold() || pressureValueProvider.provideHighPressureThreshold() < pressureValue) {
      isAlarmOn = true;
      alarmCount += 1;
    }
  }

  public boolean isAlarmOn() {
    return isAlarmOn;
  }

  public void addSensor(ISensor sensor) {
    this.sensor = sensor;
  }

  public Long getAlarmCount() {
    return alarmCount;
  }
}