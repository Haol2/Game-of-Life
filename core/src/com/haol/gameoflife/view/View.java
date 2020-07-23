package com.haol.gameoflife.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.haol.gameoflife.model.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class View implements Disposable {
    private float tileHeight;
    private float tileWidth;
    private int gridWidth;
    private int gridHeight;

    private Model model;
    private Grid grid;
    private TextButton buttonOneStep;
    private TextButton buttonTenSteps;
    private Stage stage;
    private Skin skin;

    public View(int gridWidth, int gridHeight, float tileWidth, float tileHeight, Model model, Stage stage) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.stage = stage;

        this.model = model;
        this.grid = new Grid(gridWidth, gridHeight, tileWidth, tileHeight, stage);

        this.skin = new Skin(Gdx.files.internal("default/skin/uiskin.json"));

        this.buttonOneStep = new TextButton("1 Step", skin);
        this.buttonTenSteps = new TextButton("10 Steps", skin);
        setupButtons();

    }

    public void setupButtons() {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        buttonOneStep.setPosition(100, 500);
        buttonTenSteps.setPosition(100, 100);
        buttonOneStep.setSize(400, 200);
        buttonTenSteps.setSize(400, 200);

        buttonOneStep.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.step(1);
            }
        });
        buttonTenSteps.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.step(10);
            }
        });
    }

    public void setBlack(int row, int col) {
        grid.setBlack(row, col);
    }

    public void setWhite(int row, int col) {
        grid.setWhite(row, col);
    }

    public void addGrid() {
        //stage.addActor(grid.table);

        /*
        for (Button[] row: grid.buttons) {
            for (Button col: row) {
                stage.addActor(col);
            }
        }
*/

        for (Image[] row: grid.images) {
            for (Image col: row) {
                stage.addActor(col);
            }
        }

        //grid.table.setPosition(0, stage.getHeight()/2);
        /*
        for (Image[] row : grid.images) {
            for (Image col: row) {
                stage.addActor(col);
            }
        }

         */
    }

    public void addButtons() {
        stage.addActor(buttonOneStep);
        stage.addActor(buttonTenSteps);
    }

    @Override
    public void dispose() {
        grid.textureBlack.dispose();
        grid.textureWhite.dispose();
    }

}
