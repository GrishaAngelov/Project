package com.clouway.collections.messagemanager;

import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ExceptionsMessageManager {

  private Hashtable<String, String> table;

  public ExceptionsMessageManager() {
    table = new Hashtable();
    table.put("1","Incorrect PIN!");
    table.put("2","Incorrect ID!");
    table.put("3","Incorrect Post Code!");
  }

  public void registerErrorMessage(String messageCode, String message) {
    if (!(table.containsKey(messageCode) && table.containsValue(message))) {
        table.put(messageCode,message);
      System.out.printf("Successfully added (%s,%s)\n", messageCode, message);
    } else {
          throw new DuplicateCombinationException();
    }
  }

  public String raiseError(String messageCode){
    if(table.containsKey(messageCode)){
       return table.get(messageCode);
    }
    else {
      throw new KeyNotFoundException();
    }
  }
  
  public String getErrorMessages(){
    String allMessages="";
  
   for(String item: table.values()){
     allMessages += item+"\n" ;
   }
    return allMessages;
  }
}
