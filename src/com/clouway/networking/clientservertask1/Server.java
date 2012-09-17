package com.clouway.networking.clientservertask1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Server {
    private ServerSocket serverSocket;
    private List<UI> displays;
    private DateProvider dateProvider;

    public Server(List<UI> displays, DateProvider dateProvider) {
        this.displays = displays;
        this.dateProvider = dateProvider;
    }

    public void runServer(final int port) throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(port);
                    while (Thread.currentThread().isAlive()) {

                        Socket socket = serverSocket.accept();

                        notifyDisplaysWith("\nconnected client");

                        PrintWriter writer = new PrintWriter(socket.getOutputStream());

                        writer.println(dateProvider.provideCurrentDate().toString());
                        writer.flush();
                    }

                } catch (IOException e) {
                }
            }
        }).start();
    }

    private void notifyDisplaysWith(String message) {
        for (UI display : displays) {
            display.displayMessage(message);
        }
    }
}
