package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */

public class UnitBuildButton extends TextButton {
    private unitType myType;

    public UnitBuildButton(final unitType myType){
        super(myType.toString(), Globals.skin, "small");
        this.myType = myType;
        setTransform(true);
        setScale(Globals.buttonScale);


        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Globals.gameState.respond(new UnitBuildButtonAction(myType));

                //int selectedUnit = player1Units.indexOf((Button) event.getTarget());
            }
        });
    }
}
