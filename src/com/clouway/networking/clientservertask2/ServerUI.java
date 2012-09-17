package com.clouway.networking.clientservertask2;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerUI implements UI {
    private JTextArea textArea = new JTextArea();
    private JFrame serverUI;

    public ServerUI() {
        buildServerUI();
    }

    private void buildServerUI() {
        serverUI = new JFrame("Server");
        textArea.setEditable(false);
        serverUI.add(new JScrollPane(textArea), BorderLayout.CENTER);
        serverUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverUI.setSize(250, 400);
        serverUI.setVisible(true);
    }

    @Override
    public void displayMessage(String message) {
        textArea.append(message);
    }
}
