package com.clouway.threads.tasks.timeouthashtable;

import java.util.Hashtable;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TimeoutHashtable {

  private Hashtable<String, Object> hashtable;
  private boolean isMethodUsed = false;
  private Object object;

  public TimeoutHashtable(){
    hashtable = new Hashtable<String, Object>();
    hashtable.put("Peter",25);
  }

  public void put(String key, Object value) {
    hashtable.put(key, value);
    System.out.println("pair is added...");
    isMethodUsed = true;
  }

  public Object get(String key) {
    isMethodUsed = true;
    if(hashtable.containsKey(key)){
      object = hashtable.get(key);
    }
    else {
      object = null;
    }
    return object;
  }

  public void remove(String key) {
    hashtable.remove(key);
    System.out.println("pair is removed...");
  }

  public boolean getIsUsedValue(){
    return isMethodUsed;
  }
}
