package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) throws IOException{
    DownloadAgent downloadAgent = new DownloadAgent();
    downloadAgent.downloadFile("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif");
  }
}
