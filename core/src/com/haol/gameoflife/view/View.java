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
    private TextButton buttonClear;
    private TextButton buttonStart;

    private Stage stage;
    private Skin skin;

    public View(int gridWidth, int gridHeight, float tileWidth, float tileHeight, Model model, Stage stage) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.stage = stage;

        this.model = model;
        this.grid = new Grid(gridWidth, gridHeight, tileWidth, tileHeight, stage, model);

        this.skin = new Skin(Gdx.files.internal("default/skin/uiskin.json"));

        this.buttonOneStep = new TextButton("1 Step", skin);
        this.buttonTenSteps = new TextButton("10 Steps", skin);
        this.buttonClear = new TextButton("Clear", skin);
        this.buttonStart = new TextButton("Start", skin);
        setupButtons();

    }

    public void setTileHeight(float tileHeight) {
        this.tileHeight = tileHeight;
    }

    public void setTileWidth(float tileWidth) {
        this.tileWidth = tileWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public void setModel(Model model) {
        this.model = model;
        grid.model = model;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setButtonOneStep(TextButton buttonOneStep) {
        this.buttonOneStep = buttonOneStep;
    }

    public void setButtonTenSteps(TextButton buttonTenSteps) {
        this.buttonTenSteps = buttonTenSteps;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public void setupButtons() {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();

        buttonOneStep.setPosition(100, 500);
        buttonOneStep.setSize(400, 200);
        buttonTenSteps.setPosition(100, 100);
        buttonTenSteps.setSize(400, 200);
        buttonClear.setPosition(500, 100);
        buttonClear.setSize(400, 200);
        buttonStart.setPosition(500, 500);
        buttonStart.setSize(400, 200);

/*
        buttonOneStep.setPosition(100, 100);
        buttonTenSteps.setPosition(300, 100);
        buttonOneStep.setSize(200, 100);
        buttonTenSteps.setSize(200, 100);
        */
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
        buttonClear.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                model.reset();
                grid.reset();
            }
        });
        buttonStart.addListener(new ClickListener(){
            private boolean running = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                while (true) {
                    model.step(1);
                    try {
                        wait(1);
                    } catch (InterruptedException e) {}
                }
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
        stage.addActor(buttonClear);
        stage.addActor(buttonStart);
    }

    @Override
    public void dispose() {
        grid.textureBlack.dispose();
        grid.textureWhite.dispose();
    }

    public float getTileHeight() {
        return tileHeight;
    }

    public float getTileWidth() {
        return tileWidth;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public Model getModel() {
        return model;
    }

    public Grid getGrid() {
        return grid;
    }

    public TextButton getButtonOneStep() {
        return buttonOneStep;
    }

    public TextButton getButtonTenSteps() {
        return buttonTenSteps;
    }

    public Stage getStage() {
        return stage;
    }

    public Skin getSkin() {
        return skin;
    }
}
