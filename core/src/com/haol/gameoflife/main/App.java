package com.haol.gameoflife.main;

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
	Model model;
	View view;
	SpriteBatch batch;
	Texture texture;

	@Override
	public void create () {
		model = new Model(new Matrix(gridWidth, gridHeight));
		gridWidth = (int)(Gdx.graphics.getWidth()/tileWidth);
		gridHeight = (int)(Gdx.graphics.getHeight()/tileHeight);
		view = new View(gridWidth, gridHeight, tileWidth, tileHeight, model, batch);
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		/*
		wenn neuer step:
		model.step;
		 */
		view.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
