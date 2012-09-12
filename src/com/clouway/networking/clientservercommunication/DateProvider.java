package com.clouway.networking.clientservercommunication;

import java.util.Calendar;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DateProvider {
  public String getCurrentDate() {
    Calendar calendar = Calendar.getInstance();
    return calendar.getTime().toString();
  }
}
