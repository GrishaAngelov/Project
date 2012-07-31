package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgentGUI extends JFrame {
  private JTextField addressBar = new JTextField();
  private JProgressBar progressBar = new JProgressBar();
  private DownloadAgent downloadAgent = new DownloadAgent();

  public DownloadAgentGUI(JButton button) {
    setTitle("DownloadAgent");
    setLayout(new FlowLayout());
    add(new Label("enter URL"));
    setUpAddressBar(addressBar);
    add(progressBar);
    downloadAgent.setProgressBar(progressBar);
    button.addActionListener(new DownloadButtonHandler(addressBar, downloadAgent));
    add(button);
  }

  private void setUpAddressBar(JTextField addressBar) {
    addressBar.setColumns(20);
    add(addressBar);
  }
}
