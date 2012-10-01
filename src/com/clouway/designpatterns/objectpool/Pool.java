package com.clouway.designpatterns.objectpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Pool {
  private List<Integer> availableObjects = new ArrayList<Integer>();
  private List<Integer> usedObjects = new ArrayList<Integer>();
  private int capacity;

  public Pool(int capacity) {
    this.capacity = capacity;
    fillPoolWithObjects();
  }

  public int getCurrentCapacity() {
    return availableObjects.size();
  }

  public Integer acquire() {
    Integer acquiredObject;
    if (availableObjects.size() == 0) {
      throw new NoAvailableElementsException();
    } else {
      acquiredObject = availableObjects.get(availableObjects.size() - 1);
      usedObjects.add(acquiredObject);
      availableObjects.remove(availableObjects.size() - 1);
    }
    return acquiredObject;
  }

  public void release(Integer acquireObject) {
    if (usedObjects.contains(acquireObject)) {
      availableObjects.add(acquireObject);
    } else {
      throw new ReleasePoolObjectException();
    }
  }

  public void fillPoolWithObjects() {
    for (int i = 0; i < capacity; i++) {
      availableObjects.add(new Integer(new Random().nextInt(100)));
    }
  }

}
