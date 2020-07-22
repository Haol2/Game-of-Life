package com.haol.gameoflife.main;

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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.haol.gameoflife.model.*;
import com.haol.gameoflife.view.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class App extends ApplicationAdapter {
	private int gridWidth = 30;
	private int gridHeight = 60;
	private final double tileWidth = 60;
	private final double tileHeight = 60;

	Stage stage;
	Model model;
	View view;
	SpriteBatch batch;
	Button button;
	BitmapFont font;
	Drawable drawable;
	TextureRegion region;
	Actor actor;

	@Override
	public void create () {
		stage = new Stage();
		model = new Model(new Matrix(gridWidth, gridHeight));
		view = new View(gridWidth, gridHeight, tileWidth, tileHeight, model, batch);
		batch = new SpriteBatch();
		font = new BitmapFont();
		region = new TextureRegion(new Texture("badlogic.jpg"),0,0,50,50);
		drawable = new TextureRegionDrawable(region);
		button = new ImageButton(drawable);
		actor = new Image(region);

		Gdx.input.setInputProcessor(stage);
		//view.addActors(stage);
		button.setPosition(stage.getHeight()/2, stage.getWidth()/2);
		

		gridWidth = (int)(stage.getWidth()/tileWidth);
		gridHeight = (int)(stage.getHeight()/tileHeight);


		stage.addActor(button);
		stage.addActor(actor);
	}



	@Override
	public void render () {
		stage.draw();
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		font.draw(batch, "Hello slsdosdk!!!!!", stage.getWidth()/2, stage.getHeight());
		//wenn neuer step:
		//model.step;

		//view.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
	}
}
