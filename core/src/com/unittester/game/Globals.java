package com.unittester.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class Globals {
    static int maxArmies = 4;
    static float buttonScale = 1.0f;
    static Skin skin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
    static BitmapFont font = new BitmapFont();
    static State gameState = new SelectNextUnitState();
    static Table table;
    static ArmyContainer armyContainers[] = {new ArmyContainer(), new ArmyContainer()};
}