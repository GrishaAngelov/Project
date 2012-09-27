package com.clouway.designpatterns.singleton;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SingletonTest {

  @Test
  public void singletonReturnAlwaysSameInstance() {
    Singleton firstSingletonInstance = Singleton.getInstance();
    Singleton secondSingletonInstance = Singleton.getInstance();

    assertThat(firstSingletonInstance, is(secondSingletonInstance));
  }
}
