package com.clouway.testing.myexamples.template;
import java.util.List;
import java.util.Collections;


/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TemplateParse {
  public List<String> parse(String template) {
    return Collections.singletonList(template);
    //singletonList returns an immutable list containing only the specified object. The returned list is serializable.
  }
}
