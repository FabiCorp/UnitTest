package com.unittester.game.network;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Fabian Wenzel
 *         Created by Fabian Wenzel on 27.06.2017.
 */
public class ClientSocket {
    private String ip = "";
    private int port = 1234;
    private Socket socket;

    public ClientSocket(String ip) {
        this.ip = ip;
        try {
            socket = new Socket(ip, port);
            System.out.println("ClientSocket is connected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean send(Object dataString) {
        if (!socket.isConnected()) {
            return false;
        }
        try {
            ObjectOutputStream  os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(dataString);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
