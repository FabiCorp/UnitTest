package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class FightGameStateNoUnitSelected extends GameState {
    @Override
    public void respond(GameAction action) {
        if (action instanceof ActiveUnitButtonAction)
            action.doAction(this);
    }
}
