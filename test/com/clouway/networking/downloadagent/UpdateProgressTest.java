package com.clouway.networking.downloadagent;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UpdateProgressTest {
  private MyDownloadAgent agent;
  private MyProgressBar progressBar;


  @Before
  public void setUp() {
    agent = new MyDownloadAgent();
    progressBar = new MyProgressBar();
    progressBar.addObserver(agent);
  }
  @Test
  public void updateProgress() {

    progressBar.update();
    String updateProgress = agent.getUpdateInformation();
    assertEquals("12345678910", updateProgress);
  }

  class MyDownloadAgent implements ProgressObserver {
    int maxValue;
    StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void update(int value) {
      stringBuilder.append(value);
    }

    @Override
    public void setMaxValue(int value) {
      maxValue = value;
    }

    public String getUpdateInformation() {
      return stringBuilder.toString();
    }
  }

  class MyProgressBar implements ObservableObject {
    private List<ProgressObserver> observerList = new ArrayList<ProgressObserver>();

    @Override
    public void addObserver(ProgressObserver progressObserver) {
      observerList.add(progressObserver);
    }

    public void update() {
      for (int i = 0; i < 10; i++) {
        for (ProgressObserver observer : observerList) {
          observer.update(i + 1);
        }
      }
    }
  }
}