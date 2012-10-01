package com.clouway.designpatterns.objectpool;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PoolTest {
  private final int CAPACITY = 3;
  private Pool pool;

  @Before
  public void setUp() {
    pool = new Pool(CAPACITY);
  }

  @Test
  public void numberOfContainedObjectsInPoolCorrespondToInitialCapacity() {
    assertCurrentPoolCapacityEqualTo(CAPACITY);
  }

  @Test
  public void acquireOneObjectFromPool() throws Exception {
    acquireObjects(1);
    assertCurrentPoolCapacityEqualTo(CAPACITY - 1);
  }

  @Test
  public void acquireAllObjectsFromPool() {
    acquireObjects(CAPACITY);
    assertCurrentPoolCapacityEqualTo(0);
  }

  @Test(expected = NoAvailableElementsException.class)
  public void acquireMoreObjectsThanPoolContains() {
    acquireObjects(CAPACITY + 1);
  }

  @Test
  public void releaseOneAcquiredObject() {
    Integer integer = pool.acquire();
    assertCurrentPoolCapacityEqualTo(CAPACITY - 1);

    pool.release(integer);
    assertCurrentPoolCapacityEqualTo(CAPACITY);
  }

  @Test (expected = ReleasePoolObjectException.class)
  public void releaseObjectNotFromPool(){
    pool.release(new Integer(45865));
  }

  private void assertCurrentPoolCapacityEqualTo(int capacity) {
    assertThat(capacity, is(pool.getCurrentCapacity()));
  }

  private void acquireObjects(int count) {
    for (int i = 0; i < count; i++) {
      pool.acquire();
    }
  }
}
