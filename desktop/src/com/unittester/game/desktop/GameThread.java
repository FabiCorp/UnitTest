package com.unittester.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.unittester.game.UnitTester;

/**
 * Created by Wolfgang Wenzel on 04.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class GameThread extends Thread {
    private final int player;

    public GameThread(int player) {
        this.player = player;
    }
    public void run() {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Unit Tester";
        // cfg.useGL20 = true;
        cfg.height = 800;
        cfg.width = 1200;
        new LwjglApplication(new UnitTester(player), cfg);
    }
}
