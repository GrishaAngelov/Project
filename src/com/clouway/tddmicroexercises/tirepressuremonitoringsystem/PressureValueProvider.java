package com.clouway.tddmicroexercises.tirepressuremonitoringsystem;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PressureValueProvider {
  private final double LOW_PRESSURE_THRESHOLD = 17;
  private final double HIGH_PRESSURE_THRESHOLD = 21;

  private final double NORMAL_PRESSURE_VALUE = 18.56;
  private final double TOO_HIGH_PRESSURE_VALUE = 25.32;
  private final double TOO_LOW_PRESSURE_VALUE = 5.25;


  public double provideLowPressureThreshold() {
    return LOW_PRESSURE_THRESHOLD;
  }

  public double provideHighPressureThreshold() {
    return HIGH_PRESSURE_THRESHOLD;
  }

  public double provideNormalPressureValue() {
    return NORMAL_PRESSURE_VALUE;
  }

  public double provideTooHighPressureValue() {
    return TOO_HIGH_PRESSURE_VALUE;
  }

  public double provideTooLowPressureValue() {
    return TOO_LOW_PRESSURE_VALUE;
  }
}
