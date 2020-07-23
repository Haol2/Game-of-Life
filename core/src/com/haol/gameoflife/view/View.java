package com.haol.gameoflife.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
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

    public View(int gridWidth, int gridHeight, float tileWidth, float tileHeight, Model model) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;

        this.model = model;
        this.grid = new Grid(gridWidth, gridHeight, tileWidth, tileHeight);
    }

    public void addGrid(Stage stage) {
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

    @Override
    public void dispose() {
        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                grid.textureBlack.dispose();
            }
        }
    }

}
