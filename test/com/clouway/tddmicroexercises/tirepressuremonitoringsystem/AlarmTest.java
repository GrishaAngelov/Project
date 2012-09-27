package com.clouway.tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AlarmTest {
  private Alarm alarm;
  private MockSensor mockSensor;
  private PressureValueProvider valueProvider = new PressureValueProvider();

  @Before
  public void setUp() {
    alarm = new Alarm();
    mockSensor = new MockSensor();
  }

  @Test
  public void alarmIsTurnedOffByDefault() {
    assertThat(false, is(alarm.isAlarmOn()));
  }

  @Test
  public void alarmShouldNotBeTurnedOnWhenPressureValueIsInAcceptableRange() {
    mockSensor.addPressureValue(valueProvider.provideNormalPressureValue());
    checkAlarmWithSensor(mockSensor);
    assertThat(false, is(alarm.isAlarmOn()));
    assertThat(0L, is(alarm.getAlarmCount()));
  }

  @Test
  public void alarmShouldBeTurnedOnWhenPressureValueIsTooHigh() {
    mockSensor.addPressureValue(valueProvider.provideTooHighPressureValue());
    checkAlarmWithSensor(mockSensor);
    assertThat(true, is(alarm.isAlarmOn()));
    assertThat(1L, is(alarm.getAlarmCount()));
  }

  @Test
  public void alarmShouldBeTurnedOnWhenPressureValueIsTooLow() {
    mockSensor.addPressureValue(valueProvider.provideTooLowPressureValue());
    checkAlarmWithSensor(mockSensor);
    assertThat(true, is(alarm.isAlarmOn()));
    assertThat(1L, is(alarm.getAlarmCount()));
  }

  class MockSensor implements ISensor {
    private double pressureValue;

    public void addPressureValue(double pressureValue) {
      this.pressureValue = pressureValue;
    }

    public double popNextPressurePsiValue() {
      return pressureValue;
    }
  }

  private void checkAlarmWithSensor(ISensor sensor) {
    alarm.addSensor(sensor);
    alarm.check();
  }
}
