package com.haol.gameoflife.View;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;

public class Grid {
    double tileHeight;
    double tileWidth;
    int gridWidth;
    int gridHeight;
    ArrayList<ArrayList<Texture>> textures;

    public Grid(double tileHeight, double tileWidth, int gridWidth, int gridHeight, Batch batch) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;

        textures = new ArrayList<ArrayList<Texture>>(gridHeight);
        for (ArrayList<Texture> i : textures) i = new ArrayList<Texture>(gridWidth);

        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                //Fehler hier
                if (i < textures.get(0).size() && j < textures.size()) {
                    textures.get(j).set(i, new Texture(new FileHandle("assets/cell_black")));
                }
            }
        }
    }

    public void draw (Batch batch) {
        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                batch.draw(textures.get(j).get(i), (float)(i*tileWidth), (float)(j*tileHeight));
            }
        }
    }
}
