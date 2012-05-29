package com.clouway.testing.myexamples.template;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TemplateTest {

  @Test
  public void testOnePlaceholderTemplate(){
    Template template = new Template("Hello, ${name}!");
    template.set("name", "user");
    assertEquals("Hello, user!",template.evaluate());
  }

  @Test
  public void testMultiplePlaceholderTemplate(){
    Template template = new Template("${one}, ${two}, ${three}");
    template.set("one","1");
    template.set("two","2");
    template.set("three","3");
    assertEquals("1, 2, 3",template.evaluate());
  }

  @Test
  public void testUnknownVariablesAreIgnored(){
    Template template = new Template("Hello, ${name}!");
    template.set("name","John");
    template.set("age","20");
    template.set("address","20");
    template.set("email","20");
    assertEquals("Hello, John!",template.evaluate());
  }
}
