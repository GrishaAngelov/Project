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

  /**
   * Update the progress bar with the provided value
   *
   * @param value
   */
  @Override
  public void update(int value) {
    progressBar.setValue(value);
  }
}
