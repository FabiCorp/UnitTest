package com.unittester.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static com.unittester.game.Globals.skin;

public class UnitTester extends ApplicationAdapter {

	private Stage stage;
	private Table table;
	private TextButton button;



	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		table = new Table();
		Globals.table = table;
        table.setSkin(skin);
		table.setFillParent(true);

        Drawable patch = new TextureRegionDrawable(new TextureRegion(new Texture("light-blue.png")));
		table.setBackground(patch);
		stage.addActor(table);

		table.setDebug(true);

        Label l = new Label("Unit", skin, "font", "black");
        l.setScale(0.8f*Globals.buttonScale);
        table.add(l);
        HorizontalGroup horizontalGroup = new HorizontalGroup();
        table.add(horizontalGroup);
        for (UnitType ut : UnitType.values()) {
             button = new UnitBuildButton(ut);
            horizontalGroup.addActor(button);
        }
        table.row();

        for(int player = 0; player<2; player++) {
            l = new Label("Player " + (player+1), skin, "font", "black");
            l.setScale(0.8f*Globals.buttonScale);
            table.add(l);
            table.row();
            for (int i = 0; i < Globals.maxArmies; i++) {
                button = new CityButton(i,player);
                table.add(button);
                horizontalGroup = new HorizontalGroup();
                Globals.armyContainers[player].addHorizontalGroup(horizontalGroup);
                table.add(horizontalGroup);
                table.row();
            }
        }
        table.add(new StartFightButton());
	}

    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
        //table.setSize(width,height);
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();

	}
}
