package com.clouway.testing.myexamples.matcherexample;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.Matcher;
import org.junit.Test;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MatcherTest {

  //-------------------- Core Matchers --------------------

  @Test
  public void testIsMatcher() {
    //A matcher that checks if the given objects are equal.

    int a = 5;
    int b = 4;
    assertThat(9, is(a + b));
  }

  @Test
  public void testDescribedAsMatcherCorrectExample() {
    //Wraps an existing matcher and overrides the description when it fails.

    int a = 5;
    int b = 4;
    assertThat(9, describedAs("Your result is incorrect!", is(a + b)));
  }

  @Test (expected = AssertionError.class)
  public void testDescribedAsMatcherErrorExample() {
    //Wraps an existing matcher and overrides the description when it fails.

    int a = 5;
    int b = 4;
    assertThat(19,describedAs("Your result is incorrect!",is(a + b)) );
  }

  @Test
  public void testAnyMatcher() {
    //Is the value an instance of a particular type

    int a = 5;
    String str = "hello";
    assertThat(a, any(Integer.class));
    assertThat(str, any(String.class));
  }

  //-------------------- Logical Matchers --------------------

  @Test
  public void testAllOfMatcherCorrectExample() {
    //Evaluates to true only if ALL of the passed in matchers evaluate to true.

    int result = 10;
    assertThat(result, allOf(is(5 + 5), is(8 + 2), is(3 + 7)));
  }

  @Test (expected = AssertionError.class)
  public void testAllOfMatcherErrorExample() {
    //Evaluates to true only if ALL of the passed in matchers evaluate to true.

    int result = 10;
    assertThat(result,allOf(is(5+5),is(8+2),is(3+5)));
  }

  @Test
  public void testAnyOfMatcher() {
    //Takes an array of matchers, and at least one of the matchers must report that it matches the target object.

    int result = 10;
    Matcher[] myMatchers = {is(5 + 5), is(8 + 2), is(3 + 7)};
    assertThat(result, allOf(myMatchers));
//    assertThat(result,allOf(is(5+5),is(8+2),is(3+7)));
  }

  @Test(expected = AssertionError.class)
  public void testNotMatcher() {
    //Negates the output of the previous matcher.

    int a = 6;
    int b = 4;
    int result = a + b;
    assertThat(result, not(is(a + b)));
  }

  //-------------------- Logical Matchers --------------------

  @Test
  public void testEqualToMatcherCorrectExample() {
    //A matcher that checks if the given objects are equal.

    Integer int1 = new Integer(5);
    Integer int2 = new Integer(5);
    assertThat(int1, equalTo(int2));
  }

  @Test (expected = AssertionError.class)
  public void testEqualToMatcherErrorExample() {
    //A matcher that checks if the given objects are equal.
    Integer int1 = new Integer(5);
    Integer int2 = new Integer(15);
    assertThat(int1, equalTo(int2));
  }

  @Test
  public void testInstanceOfMatcher() {
    //Checks if the given object is of type X or is compatible with type X

    Integer myInt = new Integer(5);
    assertThat(myInt, is(instanceOf(Integer.class)));
  }

  @Test
  public void testNotNullValueMatcherCorrectExample() {
    //Tests whether the given object is null or not null.

    Integer myInt1 = new Integer(5);
    assertThat(myInt1, notNullValue(Integer.class));
  }

  @Test (expected = AssertionError.class)
  public void testNotNullValueMatcherErrorExample() {
    //Tests whether the given object is null or not null.

    Integer myInt2 = null;
    assertThat(myInt2, notNullValue(Integer.class));
  }
}
