package com.clouway.testing.myexamples.template;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Template {
  private String templateText;
  private Map<String, String> variables;

  public Template(String templateText) {
    this.templateText = templateText;
    variables = new HashMap<String, String>();
  }

  public void set(String placeholder, String value) {
    variables.put(placeholder, value);
  }

  public String evaluate() {
    String result = templateText;
    for (Map.Entry<String, String> entry : variables.entrySet()) {
      String regex = "\\$\\{" + entry.getKey() + "\\}";
      result = result.replaceAll(regex, entry.getValue());
    }
    return result;
  }
}
