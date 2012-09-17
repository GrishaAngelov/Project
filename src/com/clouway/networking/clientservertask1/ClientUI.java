package com.clouway.networking.clientservertask1;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientUI implements UI {
    private JTextArea textArea = new JTextArea();
    private JFrame clientUI;

    public ClientUI() {
        buildClientUI();
    }

    private void buildClientUI() {
        clientUI = new JFrame("Client");
        textArea.setEditable(false);
        clientUI.add(textArea, BorderLayout.CENTER);
        clientUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientUI.setSize(250, 100);
        clientUI.setVisible(true);
        clientUI.setResizable(false);
    }

    @Override
    public void displayMessage(String message) {
        textArea.append(message);
    }
}
