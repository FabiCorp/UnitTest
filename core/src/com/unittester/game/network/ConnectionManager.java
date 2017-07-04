package com.unittester.game.network;

/**
 * Created by Wolfgang Wenzel on 04.07.2017.
 * Copyright Wolfgang Wenzel
 */
public abstract class ConnectionManager {
    public abstract Object getData();
    public abstract void sendData(Object data);
}
