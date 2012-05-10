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

  public PageBean(List list, int pageSize) {
    itemList = list;
    this.pageSize = pageSize;
    totalPages = (int) Math.ceil((list.size() / (double) pageSize));
    index = -pageSize;
  }

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

  public int getCurrentPageNumber() {
    return currentPage;
  }

  public List<T> firstPage() {
    index = 0;
    pageList = itemList.subList(index, index + pageSize);
    currentPage = 1;
    return pageList;
  }

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
}
