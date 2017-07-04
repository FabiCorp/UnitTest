package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class StartFightButton extends TextButton{

    public StartFightButton(){
        super("Fight", Globals.skin, "small");

        setTransform(true);
        setScale(Globals.buttonScale);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Globals.singlePlayer)
                    Globals.gameGameState = new FightGameStateNoUnitSelected();
                else {
                    Globals.connectionManager.sendData(this);
                    GameState dummy = new WaitForOtherPlayerGameState();
                }
            }
        });
    }
}
