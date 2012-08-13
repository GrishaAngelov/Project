package com.clouway.networking.downloadagent;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProgressBar implements ProgressObserver {
  private JProgressBar progressBar;

  public ProgressBar(JProgressBar progressBar) {
    this.progressBar = progressBar;
  }

  @Override
  public void update(int value) {
    progressBar.setValue(value);
  }

  @Override
  public void setMaxValue(int value) {
    progressBar.setMaximum(value);
  }
}
