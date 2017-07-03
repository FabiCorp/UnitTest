package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class UnitBuildButtonAction extends GameAction {

    unitType ut;
    public UnitBuildButtonAction(unitType ut)
    {
        this.ut = ut;

    }

    public void doAction(State state){
        Globals.gameState = new PlaceUnitInCityState(this);
    }
    public unitType getUt() {
        return ut;
    }


}
