package com.clouway.designpatterns.objectpool;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PoolTest {
  private final int CAPACITY = 3;
  private Pool pool;
  private List<Object> acquiredObjectsList = new ArrayList<Object>();

  @Before
  public void setUp() {
    pool = new Pool(CAPACITY);
  }

  @Test
  public void acquireZeroObjects() {
    assertThat(true, is(acquireObjects(0).isEmpty()));
  }

  @Test
  public void acquireOneObject() throws Exception {
    assertThat(1, is(acquireObjects(1).size()));
  }

  @Test
  public void acquireAllObjects() {
    assertThat(CAPACITY, is(acquireObjects(CAPACITY).size()));
  }

  @Test(expected = NoAvailableElementsException.class)
  public void acquireMoreObjectsThanPoolContains() {
    acquireObjects(CAPACITY + 1);
  }

  @Test
  public void releaseOneAcquiredObject() {
    Object integer = pool.acquire();
    pool.release(integer);
    assertThat(CAPACITY,is(acquireObjects(CAPACITY).size()));
  }

  @Test(expected = ReleasePoolObjectException.class)
  public void releaseObjectNotFromPool() {
    pool.release(new Integer(45865));
  }


  private List<Object> acquireObjects(int count) {
    acquiredObjectsList.clear();
    for (int i = 0; i < count; i++) {
      acquiredObjectsList.add(pool.acquire());
    }
    return acquiredObjectsList;
  }
}
