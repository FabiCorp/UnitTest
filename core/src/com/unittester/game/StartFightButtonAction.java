package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 04.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class StartFightButtonAction extends GameAction {
    @Override
    void doAction(GameState gameState) {
        if (gameState instanceof SelectNextUnitGameState) {
            Globals.gameGameState = new FightGameStateNoUnitSelected();
            if (!Globals.singlePlayer)
                Globals.connectionManager.sendData(this);
        }
    }
}
