package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */

public class SelectNextUnitGameState extends GameState {
    public SelectNextUnitGameState() {
        // System.out.println("GameState is SelectNext Unit");
    }
    @Override
    public void respond(GameAction action) {
        System.out.println("Action is: " + action.getClass());
        if (action instanceof UnitBuildButtonAction)
            action.doAction(this);
        else if (action instanceof ActiveUnitButtonAction)
            action.doAction(this);

    }
}

