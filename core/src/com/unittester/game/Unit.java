package com.unittester.game;

import java.util.Random;



/**
 * Created by Wolfgang Wenzel on 27.06.2017.
 * Copyright Wolfgang Wenzel
 */

enum UnitType { Builder, Soldier, Tank, Plane };

public class Unit {
    private static final double[][] apTable = {{2,2,2,2},
            {10,10,10,10},
            {20,20,20,0},
            {10,10,20,10}
    };
    private static Random random = new Random();


    private int defensePoints;
    private int maxDefensePoints;
    private double experience;
    private int currentDamage; // damage in last fight
    private UnitType myType;
    private ArmyModifiers modifiers;
    private static final char[] initialDefensePoints = {5,10,50,50};

    public static Unit createUnitInArmy(UnitType u, ArmyModifiers modifiers) { return new Unit(u,modifiers);}

    private Unit(UnitType myType, ArmyModifiers modifiers){
        this.myType = myType;
        this.modifiers = modifiers;
        defensePoints =initialDefensePoints[myType.ordinal()];
        maxDefensePoints = defensePoints;
        currentDamage  = 0;
        experience     = 1.0;
    }

    public ArmyModifiers getModifiers() { return modifiers; }
    public double getExperience() {
        return experience;
    }

    void fight(Unit defendingUnit) {
        if (defensePoints == 0)
            return;

        double attackPoints = apTable[myType.ordinal()][defendingUnit.myType.ordinal()];
        double aExperience = getExperience();
        double dExperience = defendingUnit.getExperience();
        // apply modifiers
        double apModifier = modifiers.getAttackModifiers(myType,defendingUnit.myType);
        double dpModifier = defendingUnit.modifiers.getDefenseModifiers(defendingUnit.myType,myType);


        double effectiveAP = attackPoints*aExperience/dExperience*apModifier/dpModifier;
        if (2*defensePoints < maxDefensePoints) // more than 50% damaged
            effectiveAP *= 0.5;
        int damageNow = (int)(0.5*effectiveAP*(1.0 + random.nextDouble()));

        //gameLogger.finest("        Fight: " + myType + " " + defendingUnit.myType + " AP: " + String.format("%4.0f",effectiveAP) + " D: " + damageNow);
        defendingUnit.currentDamage += damageNow;
    }


    public UnitType getType() {
        return myType;
    }

    public int damageAccounting() {
        defensePoints -= currentDamage;
        if (defensePoints<0) defensePoints=0;
        currentDamage = 0;
        return defensePoints;
    }

    public int getTotalDefensePoiints() {
        return defensePoints + currentDamage;
    }


    public void print() {
        System.out.println("Unit: " + myType + " Points:" + defensePoints + " Exp: " + experience);
    }

    public int doDamage(Unit unit) {
        defensePoints -= 4;
        return defensePoints;
    }
}
