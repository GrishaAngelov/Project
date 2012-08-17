package com.clouway.networking.downloadagent;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UpdateProgressTest {
  private DownloadAgent agent;

  @Before
  public void setUp() {
    agent = new DownloadAgent();
  }

  @Test
  public void progressUpdate() throws IOException {
    URLConnection connection = new URL("http://www.sutincarrental.com/wp-content/uploads/2010/03/Honda-City-Sutin-Car-Rental.jpg").openConnection();
    final StringBuilder stringBuilder = new StringBuilder();
    agent.addObserver(new ProgressObserver() {
      @Override
      public void update(int value) {
        stringBuilder.append(value);
      }
    });
    agent.download(connection.getInputStream(), new FileOutputStream(new File("downloadedPicture.jpg")), connection.getContentLength());
    assertThat(stringBuilder.toString(), startsWith("123456789"));
    assertThat(stringBuilder.toString(), endsWith("9899100"));
  }
}