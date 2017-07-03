package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 03.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class WaitForNextUnitState implements State {
    GameAction actionReceived;
    public WaitForNextUnitState() {
        System.out.println("State is Waiting for next unit");
        actionReceived = (GameAction) Globals.connectionManager.getData();
        respond(actionReceived);
    }
    @Override
    public void respond(GameAction action) {
        if (action instanceof PlaceUnitInCityButtonAction)
            action.doAction(this);
        else if (action instanceof ActiveUnitButtonAction) // selected unit thrown away
            action.doAction(this);
        // TODO Catch fight button
    }

}
