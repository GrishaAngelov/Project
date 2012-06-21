package com.clouway.threads.tasks.timeouthashtable;

import java.util.Hashtable;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TimeoutHashtable {

  private Hashtable<String, Object> table = new Hashtable<String, Object>();
  private int time;
  private Object object;

  public TimeoutHashtable(int time) {
    this.time = time;
  }

  public void put(String key, Object value) {
    table.put(key, value);
    new Timer(time, table, key);
  }

  public Object get(String key) {
    if (table.contains(key)) {
      object = table.get(key);
    } else {
      object = null;
    }
    return object;
  }

  public Object remove(String key) {
    if (table.contains(key)) {
      table.remove(key);
      object = "pair removed";
    } else {
      object = null;
    }
    return object;
  }
}
