package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 29.06.2017.
 * Copyright Wolfgang Wenzel
 */
public class FightPair {
    unitType aType;
    unitType dType;
    public FightPair(unitType aType,unitType dType){
        this.aType = aType;
        this.dType = dType;
    }

    public unitType getaType() {
        return aType;
    }

    public unitType getdType() {
        return dType;
    }
}
