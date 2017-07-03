package com.unittester.game.network;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author Fabian Wenzel
 *         Created by Fabian Wenzel on 27.06.2017.
 */
public class ServerSocket {
    private int port = 1234;
    private java.net.ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream objectInputStream;

    public ServerSocket() {
        try {
            serverSocket = new java.net.ServerSocket(port);
            socket = serverSocket.accept();
            System.out.println("ServerSocket is connected!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object receive() {
        Object dataString = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            dataString = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return dataString;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataString;
    }
}
