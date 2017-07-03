package com.unittester.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.unittester.game.UnitTester;

public class DesktopLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Unit Tester";
		// cfg.useGL20 = true;
		cfg.height = 800;
		cfg.width = 1200;
		new LwjglApplication(new UnitTester(), cfg);


	}
}
