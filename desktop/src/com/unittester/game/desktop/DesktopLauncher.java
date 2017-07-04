package com.unittester.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.unittester.game.UnitTester;

public class DesktopLauncher {
	public static void main (String[] arg) {

		for(int player = 0; player < 1; player++) {
            GameThread gameThread = new GameThread(player);
            gameThread.run();
		}

	}
}
