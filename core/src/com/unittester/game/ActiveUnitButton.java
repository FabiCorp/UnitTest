package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class ActiveUnitButton extends TextButton {
    private int      city;
    private int      player;
    private Unit     unit;
    public ActiveUnitButton(final Unit unit, final int player, final int city){
        super(unit.getType().toString() + " " + unit.getTotalDefensePoiints(), Globals.skin, "small");
        this.city   = city;
        this.player = player;
        this.unit = unit;
        setTransform(true);
        setScale(Globals.buttonScale);
        final ActiveUnitButton thisButton = this;
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Globals.gameState.respond(new ActiveUnitButtonAction(thisButton,unit,player,city));
            }
        });
    }
}
