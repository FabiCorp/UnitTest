package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */

public class UnitBuildButton extends TextButton {
    private UnitType myType;

    public UnitBuildButton(final UnitType myType){
        super(myType.toString(), Globals.skin, "small");
        this.myType = myType;
        setTransform(true);
        setScale(Globals.buttonScale);


        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Clicke on Unit" + myType + " " + Globals.gameGameState.getClass());
                Globals.gameGameState.respond(new UnitBuildButtonAction(myType));

                //int selectedUnit = player1Units.indexOf((Button) event.getTarget());
            }
        });
    }
}
