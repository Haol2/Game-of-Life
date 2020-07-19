package com.haol.gameoflife.View;

import com.haol.gameoflife.Model.*;
import com.badlogic.gdx.graphics.g2d.Batch;

public class View {
    private Model model;
    private Grid grid;

    public View(Model model, Batch batch) {
        this.model = model;
        this.grid = new Grid(150, 150, 100, 100, batch);
    }

    public void draw(Batch batch) {
        grid.draw(batch);
    }
}
