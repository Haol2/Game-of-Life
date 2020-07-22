package com.haol.gameoflife.main;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.haol.gameoflife.model.*;
import com.haol.gameoflife.view.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class App extends ApplicationAdapter {
	private final float tileWidth = 60;
	private final float tileHeight = 60;
	private int gridWidth = 1;
	private int gridHeight = 1;

	Stage stage;
	Model model;
	View view;
	SpriteBatch batch;
	Button button;
	BitmapFont font;
	Drawable drawable;
	TextureRegion region;

	@Override
	public void create () {
		stage = new Stage();
		model = new Model(new Matrix(gridWidth, gridHeight));

		batch = new SpriteBatch();
		font = new BitmapFont();
		region = new TextureRegion(new Texture("badlogic.jpg"),0,0,55,55);
		drawable = new TextureRegionDrawable(region);
		button = new ImageButton(drawable);

		gridWidth = (int)(stage.getWidth()/tileWidth);
		gridHeight = (int)(stage.getHeight()/tileHeight);
		view = new View(gridWidth, gridHeight, tileWidth, tileHeight, model);

		Gdx.input.setInputProcessor(stage);
		//view.addActors(stage);
		//button.setPosition(stage.getWidth()/2, stage.getHeight()/2);
		//button.setSize(500,500);

		view.addGrid(stage);
		//stage.addActor(button);
		//stage.addActor(textbutton);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

		/*
		batch.begin();

		//font.draw(batch, "lulululu!!!!!", stage.getWidth()/2, 50);
		//batch.draw(region.getTexture(), 0, 0);

		//wenn neuer step:
		//model.step;

		//view.draw(batch);
		batch.end();
		*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
	}
}
