package com.clouway.collections.pagebean;

import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PageBean<T> {

  private List<T> itemList;
  private List<T> pageList;
  private int pageSize;
  private int currentPage = 0;
  private int totalPages;
  private int index = 0;
  private int current = 0;
  private boolean hasNext;
  private boolean hasPrevious;

  /**
   * Constructor that initialize itemList,size of the page and the start index.
   * It also calculates total number of pages.
   *
   * @param list     - the list containing elements
   * @param pageSize - number of elements defining one page
   */
  public PageBean(List list, int pageSize) {
    itemList = list;
    this.pageSize = pageSize;
    totalPages = (int) Math.ceil((list.size() / (double) pageSize));
    index = -pageSize;
  }

  /**
   * Method returns the next page from the list
   *
   * @return sublist of elements representing one page
   */
  public List<T> next() {
    currentPage++;
    index += pageSize;
    if (currentPage > totalPages) {
      currentPage--;
      index -= pageSize;
      throw new OutOfBoundsException();
    }
    if (currentPage == totalPages) {
      pageList = itemList.subList(index, itemList.size());
    } else {
      pageList = itemList.subList(index, index + pageSize);
    }
    return pageList;
  }

  /**
   * Method returns the previous page from the list
   *
   * @return sublist of elements representing one page
   */
  public List<T> previous() {
    currentPage--;
    index -= pageSize;
    if (currentPage == 0) {
      currentPage++;
      index += pageSize;
      throw new OutOfBoundsException();
    } else {
      pageList = itemList.subList(index, index + pageSize);
    }
    return pageList;
  }

  /**
   * Method returns current page number
   *
   * @return number of current page
   */
  public int getCurrentPageNumber() {
    return currentPage;
  }

  /**
   * Method skips to the first page and makes it current
   *
   * @return elements from first page
   */
  public List<T> firstPage() {
    index = 0;
    pageList = itemList.subList(index, index + pageSize);
    currentPage = 1;
    return pageList;
  }

  /**
   * Method skips to the last page and makes it current
   *
   * @return elements from last page
   */
  public List<T> lastPage() {
    index = 0;
    current = 1;
    while (current < totalPages) {
      index += pageSize;
      current++;
    }
    pageList = itemList.subList(index, itemList.size());
    currentPage = totalPages;
    return pageList;
  }

  /**
   * Method checks whether there are further elements
   *
   * @return "true" if there are further elements
   *         "false" if there are no further elements
   */
  public boolean hasNext() {
    hasNext = true;
    if (currentPage == totalPages) {
      hasNext = false;
    }
    return hasNext;
  }


  /**
   * Method checks whether there are previous elements
   *
   * @return "true" if there are previous elements
   *         "false" if there are no previous elements
   */
  public boolean hasPrevious() {
    hasPrevious = true;
    if (currentPage == 1) {
      hasPrevious = false;
    }
    return hasPrevious;
  }
}
