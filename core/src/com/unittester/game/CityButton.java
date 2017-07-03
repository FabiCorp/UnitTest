package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class CityButton extends TextButton {
    private static String armyName(int cityNumber){
        if (cityNumber==0)
            return "Army";
        else
            return "City " + cityNumber;
    }
    private int      cityNumber;
    private int      player;
    public CityButton(final int cityNumber, final int player){
        super(armyName(cityNumber), Globals.skin, "small");
        this.cityNumber = cityNumber;
        this.player = player;
        setTransform(true);
        setScale(Globals.buttonScale);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Globals.gameState.respond(new PlaceUnitInCityButtonAction(cityNumber,player));
            }
        });
    }
}
