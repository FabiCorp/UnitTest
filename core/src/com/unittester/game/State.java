package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.Event;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 * TODO make abstract clas that prints out the state in constructor
 */
interface State {
    void respond(GameAction action);
}

