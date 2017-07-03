package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 29.06.2017.
 * Copyright Wolfgang Wenzel
 */
public class FightPair {
    UnitType aType;
    UnitType dType;
    public FightPair(UnitType aType, UnitType dType){
        this.aType = aType;
        this.dType = dType;
    }

    public UnitType getaType() {
        return aType;
    }

    public UnitType getdType() {
        return dType;
    }
}
