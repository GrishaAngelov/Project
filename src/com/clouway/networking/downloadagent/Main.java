package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) throws IOException {
    ButtonBuilder buttonBuilder = new ButtonBuilder();
    JButton downloadButton = buttonBuilder.buildButton("download");
    DownloadAgentGUI agentGUI = new DownloadAgentGUI(downloadButton);
    agentGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    agentGUI.setVisible(true);
    agentGUI.setSize(250, 150);
    agentGUI.setLocation(500, 200);
    agentGUI.setResizable(false);
  }
}
