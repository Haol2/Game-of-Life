package com.haol.gameoflife;

import Model.*;
import View.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class App extends ApplicationAdapter {
	private int gridWidth;
	private int gridHeight;
	Model model;
	SpriteBatch batch;
	Texture texture;
	Pixmap pmap;

	@Override
	public void create () {
		model = new Model(new Matrix(gridWidth, gridHeight));
		batch = new SpriteBatch();
		pmap = new Pixmap(800,1000, Pixmap.Format.RGBA8888);
		pmap.setColor(Color.GOLD);
		//pmap.fill();
		pmap.drawCircle(200,200,100);
		/*
		for (int i = 0; i < 100; ++i) {
			pmap.drawPixel(2,2, 12);
		}
*/
		texture = new Texture(pmap);
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
		batch.draw(texture,1,1);
		batch.end();
	}
	
	@Override
	public void dispose () {
		pmap.dispose();
	}
}
