package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class FightGameStateUnitSelected extends GameState {
    ActiveUnitButtonAction firstUnit;
    public FightGameStateUnitSelected(ActiveUnitButtonAction action) {
        firstUnit = action;
        System.out.println("First Unit " + firstUnit.getPlayer());
    }

    @Override
    public void respond(GameAction action) {
        if (action instanceof ActiveUnitButtonAction)
            action.doAction(this);
    }
}
