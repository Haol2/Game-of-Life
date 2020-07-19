package com.haol.gameoflife.view;

import com.haol.gameoflife.model.*;
import com.badlogic.gdx.graphics.g2d.Batch;

public class View {
    private final int tileWidth = 50;
    private final int tileHeight = 50;
    private Model model;
    private Grid grid;

    public View(int gridWidth, int gridHeight, Model model, Batch batch) {
        this.model = model;
        this.grid = new Grid(tileWidth, tileHeight, gridWidth, gridHeight);
    }

    public void draw(Batch batch) {
        grid.draw(batch);
    }
}
