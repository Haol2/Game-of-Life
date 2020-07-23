package com.haol.gameoflife.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.haol.gameoflife.model.*;
import com.badlogic.gdx.graphics.g2d.Batch;

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

    public View(int gridWidth, int gridHeight, float tileWidth, float tileHeight, Model model, Stage stage) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.stage = stage;

        this.model = model;
        this.grid = new Grid(gridWidth, gridHeight, tileWidth, tileHeight, stage);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        this.buttonOneStep = new TextButton("1 Step", style);
        this.buttonTenSteps = new TextButton("10 Steps", style);
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
        buttonOneStep.setPosition(0,stage.getHeight()-100);
        buttonTenSteps.setPosition(stage.getWidth()-100, stage.getHeight()-100);
        buttonOneStep.setSize(100, 50);
        buttonTenSteps.setSize(100, 50);
        stage.addActor(buttonOneStep);
        stage.addActor(buttonTenSteps);
    }

    @Override
    public void dispose() {
        grid.textureBlack.dispose();
        grid.textureWhite.dispose();
    }

}
