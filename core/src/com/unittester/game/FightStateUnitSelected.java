package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class FightStateUnitSelected implements State {
    ActiveUnitButtonAction firstUnit;
    public FightStateUnitSelected(ActiveUnitButtonAction action) {
        firstUnit = action;
        System.out.println("First Unit " + firstUnit.getPlayer());
    }

    @Override
    public void respond(GameAction action) {
        if (action instanceof ActiveUnitButtonAction)
            action.doAction(this);
    }
}
