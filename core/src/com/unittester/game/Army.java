package com.unittester.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


import static com.unittester.game.FightOutcome.ATTACKER;
import static com.unittester.game.FightOutcome.DEFENDER;
import static com.unittester.game.FightOutcome.DRAW;
import static com.unittester.game.Unit.createUnitInArmy;
import static com.unittester.game.unitType.*;
import static java.util.logging.Level.FINEST;

/**
 * Created by Wolfgang Wenzel on 27.06.2017.
 * Copyright Wolfgang Wenzel
 */
enum FightOutcome { ATTACKER, DEFENDER, DRAW };

public class Army extends LinkedList<Unit> {

    private static ArrayList<FightPair> fightOrder = new ArrayList<FightPair>(Arrays.asList(
            new FightPair(Plane,Plane),
            new FightPair(Plane,Tank),
            new FightPair(Plane,Soldier),

            new FightPair(Tank,Plane),
            new FightPair(Tank,Tank),
            new FightPair(Tank,Soldier),

            new FightPair(Soldier,Soldier),
            new FightPair(Soldier,Tank),
            new FightPair(Soldier,Plane)
            ));

    private ArmyModifiers modifiers;
    public Army(ArmyModifiers modifiers) {
        this.modifiers = modifiers;
    }

    public FightOutcome fightAll(Army defender){

        // stage 1: air
        // not implemented: attacked city defense

        int aHp = 0;
        int dHp = 0;

        for (FightPair f : fightOrder) {

            Army a1 = selectArmyByUnit(f.getaType());
            Army a2 = defender.selectArmyByUnit(f.getdType());
            a1.fight(a2,1); // one-on-one fighting
            aHp += a1.damageAccounting();
            dHp += a2.damageAccounting();

            a1 = defender.selectArmyByUnit(f.getaType());
            a2 = selectArmyByUnit(f.getdType());
            a1.fight(a2, 1);
            aHp += a2.damageAccounting();
            dHp += a1.damageAccounting();
        }

        if (aHp > 0 && dHp == 0) {
            return ATTACKER;
        } else if (dHp > 0 && aHp == 0) {
            return DEFENDER;
        } else
            return DRAW;
    }

    public Unit addUnit(unitType ut) {
        Unit u = createUnitInArmy(ut,this.modifiers);
        this.add(u);
        return u;
    }

    public void print() {
        Iterator<Unit> aIter = this.iterator();
        while (aIter.hasNext()) {
            aIter.next().print();
        }
    }
    public void fight(Army defender,int noTargets){

        Iterator<Unit> aIter = this.iterator();
            while (aIter.hasNext()) {
                Unit a = aIter.next();
            for (int i = 0; i < noTargets; i++) {
                Unit d = defender.selectUnit();
                a.fight(d);
            }
        }
    }

    private Unit selectUnit() {
        // pick first living unit
        Iterator<Unit> unitIter = this.iterator();
        while (unitIter.hasNext()) {
            Unit u = unitIter.next();
            if (u.getTotalDefensePoiints() > 0)
                return u;
        }
        return createUnitInArmy(Builder,this.modifiers); // this is a dummy unit if there are no units that can be attacked
    }

    public int damageAccounting() {
        Iterator<Unit> unitIter = this.iterator();
        int hP = 0;
        while (unitIter.hasNext()) {
            hP += unitIter.next().damageAccounting();
        }
        return hP;
    }

    public Army selectArmyByUnit(unitType ut) {
        Army newArmy = new Army(modifiers);
        Iterator<Unit> unitIter = this.iterator();
        while (unitIter.hasNext()) {
            Unit u = unitIter.next();
            if (u.getType() == ut)
                newArmy.add(u);
        }
        return newArmy;
    }

    public int[] computeNumberOfUnitsbyType() {
        int[] number = new int[unitType.values().length];
        Arrays.fill(number,0);
        for (Unit u: this) number[u.getType().ordinal()]++;
        return number;
    }

    public static void testFighting() {
        ArmyModifiers aM = new ArmyModifiers();
        ArmyModifiers dM = new ArmyModifiers();
        dM.setEntrenched();

        Army a = new Army(aM);
        Army d = new Army(dM);

        a.addUnit(Soldier);
        d.addUnit(Soldier);

        FightOutcome fo = DRAW;
        for (int rounds=0;rounds < 2; rounds++) {
            System.out.println("Attacking Army:");
            a.print();
            System.out.println("Defending Army:");
            d.print();
            fo = a.fightAll(d);
            System.out.println("Result of Fight: " + fo);
        }
    }
}
