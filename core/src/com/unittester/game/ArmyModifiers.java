package com.unittester.game;

import java.util.ArrayList;
import java.util.Arrays;

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

    public double getAttackModifiers(unitType aType, unitType dType1) {
        return 1;
    }

    public double getDefenseModifiers(unitType myType, unitType myType1) {
        if (entrenched)
            return 1.2;
        else
            return 1.0;
    }
}
