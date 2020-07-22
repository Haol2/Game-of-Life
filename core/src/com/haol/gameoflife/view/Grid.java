package com.haol.gameoflife.view;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Grid {
    private double tileHeight;
    private double tileWidth;
    private int gridWidth;
    private int gridHeight;

    Table table;
    Texture[][] textures;
    Image[][] images;
    Button[][] buttons;

    public Grid(int gridWidth, int gridHeight, double tileWidth, double tileHeight) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;

        textures = new Texture[gridHeight][gridWidth];
        images = new Image[gridHeight][gridWidth];
        buttons = new Button[gridHeight][gridWidth];
        table = new Table();

        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                if (i < textures[0].length && j < textures.length) {
                    textures[j][i] = new Texture("cell_black.png");
                    images[j][i] = new Image(textures[j][i]);
                    table.add(images[j][i]);
                }
            }
        }
    }


    public void draw (Batch batch) {
        /*
        table.draw(batch,2);
        for (Image[] row : images) {
            for (Image col: row) {
                col.draw(batch, 2);
            }
        }

        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                batch.draw(textures[j][i], (float)(i*tileWidth), (float)(j*tileHeight));
            }
        }

         */
    }
}
