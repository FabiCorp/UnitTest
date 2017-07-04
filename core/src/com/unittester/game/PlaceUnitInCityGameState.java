package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class PlaceUnitInCityGameState extends GameState {
    public UnitBuildButtonAction getPrevious() {
        return previous;
    }

    UnitBuildButtonAction previous;
    public PlaceUnitInCityGameState(UnitBuildButtonAction previous){
        System.out.println("GameState is Place Unit in City");
        this.previous = previous;
    }
    @Override
    public void respond(GameAction action) {
        if (action instanceof PlaceUnitInCityButtonAction)
            action.doAction(this);
        else if (action instanceof ActiveUnitButtonAction) // selected unit thrown away
            action.doAction(this);
    }
}
