package com.clouway.testing.array;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ArrayUtil {
  
  private int[] myArray;
  
  public ArrayUtil(int[] array){
    myArray = array;
  }

  /**
   * Finds minimal element in the array
   * @return  minEl - minimal element
   */
  public int getMinElement() {
    int minEl = myArray[0];
    for (int i = 1; i < myArray.length; i++) {
      if (myArray[i] < minEl) {
        minEl = myArray[i];
      }
    }
    return minEl;
  }

  /**
   * Calculates the sum of all elements
   * @return the sum of all elements
   */
  public int getSum() {
    int sum = 0;
    for (int i = 0; i < myArray.length; i++){
      sum += myArray[i];
    }
    return sum;
  }

  /**
   * Prints all elements
   * @return
   */
  public String printArray(){
   StringBuilder sb = new StringBuilder();
    for (int i = 0; i < myArray.length; i++){
      sb.append(myArray[i]+" ");
    }
    return sb.toString();
  }
}
