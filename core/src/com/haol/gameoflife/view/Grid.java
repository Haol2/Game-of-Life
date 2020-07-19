package com.haol.gameoflife.view;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Grid {
    double tileHeight;
    double tileWidth;
    int gridWidth;
    int gridHeight;
   Texture[][] textures;

    public Grid(double tileWidth, double tileHeight, int gridWidth, int gridHeight) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;

        textures = new Texture[gridHeight][gridWidth];

        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                //Fehler hier
                if (i < textures[0].length && j < textures.length) {
                    textures[j][i] = new Texture("cell_black.png");
                }
            }
        }
    }

    public void draw (Batch batch) {
        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                batch.draw(textures[j][i], (float)(i*tileWidth), (float)(j*tileHeight));
            }
        }
    }
}
