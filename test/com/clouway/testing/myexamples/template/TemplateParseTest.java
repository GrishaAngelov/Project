package com.clouway.testing.myexamples.template;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TemplateParseTest {

  @Test
  public void testEmptyTemplateRendersAsEmptyString() throws Exception {
    TemplateParse parse = new TemplateParse();
    List<String> segments = parse.parse("");
    assertEquals("Number of segments", 1, segments.size());
    assertEquals("", segments.get(0));
  }

  @Test
  public void testTemplateWithOnlyPlainText() throws Exception {
    TemplateParse parse = new TemplateParse();
    List<String> segments = parse.parse("plain text only");
    assertEquals("Number of segments", 1, segments.size());
    assertEquals("plain text only", segments.get(0));
  }

}
