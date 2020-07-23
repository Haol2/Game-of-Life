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

	private OrthographicCamera camera;
	private Stage stage;
	private Model model;
	private View view;
	private SpriteBatch batch;
	private Button button;
	private BitmapFont font;
	private Drawable drawable;
	private TextureRegion region;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		stage = new Stage();
		model = new Model(gridWidth, gridHeight, view);

		batch = new SpriteBatch();
		font = new BitmapFont();
		region = new TextureRegion(new Texture("badlogic.jpg"),0,0,55,55);
		drawable = new TextureRegionDrawable(region);
		button = new ImageButton(drawable);

		gridWidth = (int)(stage.getWidth()/tileWidth);
		gridHeight = (int)(stage.getHeight()/tileHeight*0.6);
		view = new View(gridWidth, gridHeight, tileWidth, tileHeight, model, stage);

		Gdx.input.setInputProcessor(stage);

		//button.setPosition(stage.getWidth()/2, stage.getHeight()/2);
		//button.setSize(500,500);

		view.addGrid();
		view.addButtons();
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
		view.dispose();
	}
}
