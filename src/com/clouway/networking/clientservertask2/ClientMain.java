package com.clouway.networking.clientservertask2;

import java.io.IOException;

/**
 * @author: Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ClientMain {
    public static void main(String[] args) throws IOException {

        Client client = new Client(new ClientUI());
        client.connect("localhost",1580);
    }
}
