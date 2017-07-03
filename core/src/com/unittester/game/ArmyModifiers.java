package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 27.06.2017.
 * Copyright Wolfgang Wenzel
 */
public class ArmyModifiers {

    private boolean entrenched;

    void ArmyModifiers() {
        entrenched = false;
    }

    public void setEntrenched() {
        entrenched = true;
    }

    public double getAttackModifiers(UnitType aType, UnitType dType1) {
        return 1;
    }

    public double getDefenseModifiers(UnitType myType, UnitType myType1) {
        if (entrenched)
            return 1.2;
        else
            return 1.0;
    }
}
