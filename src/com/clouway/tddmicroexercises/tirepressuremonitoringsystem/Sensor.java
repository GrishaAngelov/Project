package com.clouway.tddmicroexercises.tirepressuremonitoringsystem;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.util.Random;

public class Sensor implements ISensor {
  public final double OFFSET = 16;

  public double popNextPressurePsiValue() {
    double pressureTelemetryValue;
    pressureTelemetryValue = samplePressure();

    return OFFSET + pressureTelemetryValue;
  }

  private double samplePressure() {
    // placeholder implementation that simulate a real sensor in a real tire
    Random randomNumbersGenerator = new Random(42);
    double pressureValue = 6 * randomNumbersGenerator.nextDouble() * randomNumbersGenerator.nextDouble();
    return pressureValue;
  }
}