package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */

public class SelectNextUnitState implements State {
    public SelectNextUnitState() {
        System.out.println("State is SelectNext Unit");
    }
    @Override
    public void respond(GameAction action) {
        if (action instanceof UnitBuildButtonAction)
            action.doAction(this);
        else if (action instanceof ActiveUnitButtonAction)
            action.doAction(this);
    }
}

