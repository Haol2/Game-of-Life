package com.haol.gameoflife.view;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.haol.gameoflife.model.*;
import com.badlogic.gdx.graphics.g2d.Batch;

public class View {
    private Model model;
    private Grid grid;

    public View(int gridWidth, int gridHeight, double tileWidth, double tileHeight, Model model, Batch batch) {
        this.model = model;
        this.grid = new Grid(gridWidth, gridHeight, tileWidth, tileHeight);
    }

    public void draw(Batch batch) {
        grid.draw(batch);
    }

    public void addActors(Stage stage) {
        for (Image[] row : grid.images) {
            for (Image col: row) {
                stage.addActor(col);
            }
        }
    }
}
