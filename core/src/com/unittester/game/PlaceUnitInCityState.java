package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class PlaceUnitInCityState implements State {
    public UnitBuildButtonAction getPrevious() {
        return previous;
    }

    UnitBuildButtonAction previous;
    public PlaceUnitInCityState(UnitBuildButtonAction previous){
        System.out.println("State is Place Unit in City");
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
