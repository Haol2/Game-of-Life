package com.haol.gameoflife.view;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Grid {
    double tileHeight;
    double tileWidth;
    int gridWidth;
    int gridHeight;
    Image[][] tiles;

    public Grid(int gridWidth, int gridHeight, double tileWidth, double tileHeight) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;

        tiles = new Image[gridHeight][gridWidth];

        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                if (i < tiles[0].length && j < tiles.length) {
                    tiles[j][i] = new Image(new Texture("cell_black.png"));
                }
            }
        }
    }

    public void draw (Batch batch) {
        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                batch.draw(tiles[j][i], (float)(i*tileWidth), (float)(j*tileHeight));
            }
        }
    }
}
