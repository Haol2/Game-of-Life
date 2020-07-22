package com.haol.gameoflife.view;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Grid {
    private float tileHeight;
    private float tileWidth;
    private int gridWidth;
    private int gridHeight;

    Table table;
    Texture textureBlack;
    Texture textureWhite;
    TextureRegion regionWhite;
    TextureRegion regionBlack;
    TextureRegionDrawable drawableBlack;
    TextureRegionDrawable drawableWhite;
    /*
    Texture[][] textures;
    TextureRegion[][] regions;
    TextureRegionDrawable[][] drawables;
    */
    ImageButton[][] buttons;
    ImageButton.ImageButtonStyle style;

    public Grid(int gridWidth, int gridHeight, float tileWidth, float tileHeight) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;

        textureBlack = new Texture("cell_black.png");
        textureWhite = new Texture("cell_white.png");
        regionBlack = new TextureRegion(textureBlack, 55, 55);
        regionWhite = new TextureRegion(textureWhite, 55, 55);
        drawableBlack = new TextureRegionDrawable(regionBlack);
        drawableWhite = new TextureRegionDrawable(textureWhite);
        style = new ImageButton.ImageButtonStyle();
        style.imageUp = drawableBlack;
        style.imageDown = drawableWhite;

        /*
        textures = new Texture[gridHeight][gridWidth];
        regions = new TextureRegion[gridHeight][gridWidth];
        drawables = new TextureRegionDrawable[gridHeight][gridWidth];
*/

        buttons = new ImageButton[gridHeight][gridWidth];
        table = new Table();

        createGrid();
    }



    private void createGrid() {
        for (int i = 0; i < gridWidth; ++i) {
            for (int j = 0; j < gridHeight; ++j) {
                /*
                    textures[j][i] = new Texture("cell_black.png");
                    regions[j][i] = new TextureRegion(textures[j][i], 55, 55);
                    drawables[j][i] = new TextureRegionDrawable(regions[j][i]);
                    */

                    buttons[j][i] = new ImageButton(drawableWhite);
                    buttons[j][i].setPosition(j*tileWidth, i*tileHeight);
                    buttons[j][i].setStyle(style);
                    System.out.println(j*tileWidth + ", " + i*tileHeight);
                    buttons[j][i].addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {

                        }
                    });
                    //table.add(buttons[j][i]);
            }
            //table.row();
        }
        buttons[0][0].toggle();
    }

}
