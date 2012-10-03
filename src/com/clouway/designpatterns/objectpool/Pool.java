package com.clouway.designpatterns.objectpool;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Pool {
  private Map<Object, Boolean> availableObjects = new Hashtable<Object, Boolean>();
  private int capacity;

  public Pool(int capacity) {
    this.capacity = capacity;
    fillPoolWithObjects();
  }

  public Object acquire() {
    Object acquiredObject;
    if (getFirstAvailableObject() == null) {
      throw new NoAvailableElementsException();
    } else {
      acquiredObject = getFirstAvailableObject();
      markObjectAsUnavailable(acquiredObject);
    }
    return acquiredObject;
  }

  public void release(Object acquiredObject) {
    if (availableObjects.containsKey(acquiredObject)) {
      markObjectAsAvailable(acquiredObject);
    } else {
      throw new ReleasePoolObjectException();
    }
  }

  public void fillPoolWithObjects() {
    for (int i = 0; i < capacity; i++) {
      availableObjects.put(new Integer(new Random().nextInt(100)), true);
    }
  }

  private void markObjectAsAvailable(Object acquiredObject) {
    availableObjects.put(acquiredObject, true);
  }

  private void markObjectAsUnavailable(Object acquiredObject) {
    availableObjects.put(acquiredObject, false);
  }

  private Object getFirstAvailableObject() {
    Object availableObject = null;
    for (Map.Entry entry : availableObjects.entrySet()) {
      if (entry.getValue() == Boolean.TRUE) {
        availableObject = entry.getKey();
        break;
      }
    }
    return availableObject;
  }
}
