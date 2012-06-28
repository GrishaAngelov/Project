package com.clouway.gui.progressbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyProgressbar extends JFrame {
  private JProgressBar progressBar;
  private JButton startButton;
  private JButton stopButton;
  private ButtonsHandler handler = new ButtonsHandler();
  private MyThread thread;


  public MyProgressbar() {
    super("Progressbar");
    setLayout(new FlowLayout());

    progressBar = new JProgressBar(0, 10);
    startButton = new JButton("Start");
    stopButton = new JButton("Stop");

    startButton.addActionListener(handler);
    stopButton.addActionListener(handler);

    add(progressBar);
    add(startButton);
    add(stopButton);
  }

  private class ButtonsHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == startButton) {
        progressBar.setValue(0);
        thread = new MyThread();
        thread.start();
        startButton.setEnabled(false);
      }
      if (event.getSource() == stopButton) {
        thread.tryToStop();
      }
    }
  }

  private class MyThread extends Thread {
    private boolean stop = false;

    public void run() {
      while (!stop) {
        for (int i = 0; i <= 10; i++) {
          if (!stop) {
            progressBar.setValue(i);
            progressBar.repaint();
            try {
              Thread.sleep(200);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
        tryToStop();
      }
      startButton.setEnabled(true);
    }

    public void tryToStop() {
      stop = true;
    }
  }
}
