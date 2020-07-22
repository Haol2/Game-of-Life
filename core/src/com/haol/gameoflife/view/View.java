package com.haol.gameoflife.view;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.haol.gameoflife.model.*;
import com.badlogic.gdx.graphics.g2d.Batch;

public class View {
    private Model model;
    private Grid grid;

    public View(int gridWidth, int gridHeight, float tileWidth, float tileHeight, Model model) {
        this.model = model;
        this.grid = new Grid(gridWidth, gridHeight, tileWidth, tileHeight);
    }

    public void addGrid(Stage stage) {
        //stage.addActor(grid.table);

        for (Button[] row: grid.buttons) {
            for (Button col: row) {
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
}
