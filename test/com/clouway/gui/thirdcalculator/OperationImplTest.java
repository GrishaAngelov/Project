package com.clouway.gui.thirdcalculator;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class OperationImplTest {

  private Adder adder;
  private Subtractor subtractor;
  private Multiplier multiplier;
  private Divisor divisor;

  @Before
  public void setUp(){
    adder = new Adder();
    subtractor = new Subtractor();
    multiplier  = new Multiplier();
    divisor = new Divisor();
  }

  @Test
  public void adder(){
    double result = adder.calculate(5,2);
    assertThat(result, is(equalTo(7.0)));
  }

  @Test
  public void subtractor(){
    double result = subtractor.calculate(5,2);
    assertThat(result, is(equalTo(3.0)));
  }

  @Test
  public void multiplier(){
    double result = multiplier.calculate(5,2);
    assertThat(result, is(equalTo(10.0)));
  }

  @Test
  public void divisor(){
    double result = divisor.calculate(8,2);
    assertThat(result, is(equalTo(4.0)));
  }

}
