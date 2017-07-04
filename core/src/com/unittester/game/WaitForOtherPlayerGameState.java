package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 03.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class WaitForOtherPlayerGameState extends GameState {
    GameAction actionReceived;
    public WaitForOtherPlayerGameState() {

    }
    public void doStuff() {
        actionReceived = (GameAction) Globals.connectionManager.getData();
        respond(actionReceived);
    }
    @Override
    public void respond(GameAction action) {
        if (action instanceof PlaceUnitInCityButtonAction)
            action.doAction(this);
        else if (action instanceof ActiveUnitButtonAction) // selected unit thrown away
            action.doAction(this);
        else if (action instanceof StartFightButtonAction)
            Globals.gameGameState = new FightGameStateNoUnitSelected();
    }

}
