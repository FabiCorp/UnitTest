package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class UnitBuildButtonAction extends GameAction {

    UnitType ut;
    public UnitBuildButtonAction(UnitType ut)
    {
        this.ut = ut;

    }

    public void doAction(State state){
        Globals.gameState = new PlaceUnitInCityState(this);
    }
    public UnitType getUt() {
        return ut;
    }


}
