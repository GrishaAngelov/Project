package com.clouway.testing.array;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ArrayUtilTest {
  
  private ArrayUtil arrayUtil1;
  private ArrayUtil arrayUtil2;
  private int[] arr = {5,1,4,9};
  private int[] emptyArr = new int[]{};
  
  @Before
  public void createArrayUtil(){
    arrayUtil1 = new ArrayUtil(arr);
  }

  @Test
  public void testGetMinElement(){
    assertEquals(1,arrayUtil1.getMinElement());
  }

  @Test
  public void testGetSum(){
    assertEquals(19,arrayUtil1.getSum());
  }
  
  @Test
  public void testPrintArray(){
       assertEquals("5 1 4 9 ",arrayUtil1.printArray());
  }
}
