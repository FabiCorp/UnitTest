package com.unittester.game.network;

/**
 * Created by Wolfgang Wenzel on 04.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class SinglePlayerConnectionManager extends ConnectionManager {

    private static boolean dataReceived;
    Object object;
    public SinglePlayerConnectionManager() {
        dataReceived = false;
    }

    public void sendData(Object object) {
        if (dataReceived)
            System.out.println("SinglePlayerConnectionManagerError: Data already there");
        dataReceived=true;
        System.out.println("sendData " + object.getClass());
        this.object = object;
    }

    public Object getData() {
        if (!dataReceived)
            System.out.println("SinglePlayerConnectionManagerError: No Bloody Data");
        System.out.println("getData:" + object.getClass());
        dataReceived=false;
        return this.object;
    }



}
