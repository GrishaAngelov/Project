package com.clouway.networking.clientservertask2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {
        List<UI> serverUIList = new ArrayList<UI>();
        serverUIList.add(new ServerUI());
        Server server = new Server(serverUIList);
        server.runServer(1580);
    }
}
