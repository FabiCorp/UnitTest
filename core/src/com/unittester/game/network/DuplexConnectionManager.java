package com.unittester.game.network;


/**
 * @author Fabian Wenzel
 *         Created by Fabian Wenzel on 27.06.2017.
 */
public class DuplexConnectionManager extends ConnectionManager {

    private ClientSocket clientSocket;
    private ServerSocket serverSocket;

    public DuplexConnectionManager(String ip) {
        startServer();
        clientSocket = new ClientSocket(ip);
    }

    private void startServer() {
        Thread thread = new Thread(() -> serverSocket = new ServerSocket());
        thread.start();
    }

    @Override
    public Object getData() {
        return serverSocket.receive();
    }

    @Override
    public void sendData(Object data) {
        clientSocket.send(data);
    }



}
