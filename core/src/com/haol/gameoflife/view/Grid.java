package com.haol.gameoflife.view;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Grid {
    private float tileHeight;
    private float tileWidth;
    private int gridWidth;
    private int gridHeight;

    Table table;
    Texture[][] textures;
    TextureRegion[][] regions;
    TextureRegionDrawable[][] drawables;
    Button[][] buttons;

    public Grid(int gridWidth, int gridHeight, float tileWidth, float tileHeight) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;

        textures = new Texture[gridHeight][gridWidth];
        regions = new TextureRegion[gridHeight][gridWidth];
        drawables = new TextureRegionDrawable[gridHeight][gridWidth];
        buttons = new Button[gridHeight][gridWidth];
        table = new Table();

        createGrid();
    }

    private void createGrid() {
        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                if (i < textures[0].length && j < textures.length) {
                    //new TextureRegion(new Texture("badlogic.jpg"),0,0,50,50);
                    textures[j][i] = new Texture("cell_black.png");
                    regions[j][i] = new TextureRegion(textures[j][i], 55, 55);
                    drawables[j][i] = new TextureRegionDrawable(regions[j][i]);
                    buttons[j][i] = new ImageButton(drawables[j][i]);
                    buttons[j][i].setSize(tileWidth, tileHeight);
                    buttons[j][i].setPosition(j*tileWidth, i*tileHeight);
                    System.out.println(j*tileWidth + ", " + i*tileHeight);
                    //table.add(buttons[j][i]);
                }
            }
            //table.row();
        }
    }

}
