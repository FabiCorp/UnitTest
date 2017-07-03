package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;

import java.util.ArrayList;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class ArmyContainer extends ArrayList<Army> {
    ArrayList<HorizontalGroup> horizontalGroups;
    public ArmyContainer() {
        super(Globals.maxArmies);
        while(size() < Globals.maxArmies) add(new Army(new ArmyModifiers()));
        horizontalGroups = new ArrayList<HorizontalGroup>(Globals.maxArmies);
    }
    void addHorizontalGroup(HorizontalGroup horizontalGroup) {
        horizontalGroups.add(horizontalGroup);
    }

}
