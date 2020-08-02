package com.haol.gameoflife.view;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.haol.gameoflife.model.Model;

import javax.sound.midi.SysexMessage;

public class Grid {
    private float tileHeight;
    private float tileWidth;
    private int gridWidth;
    private int gridHeight;

    Stage stage;
    Model model;
    Texture textureBlack;
    Texture textureWhite;
    TextureRegion regionWhite;
    TextureRegion regionBlack;
    TextureRegionDrawable drawableBlack;
    TextureRegionDrawable drawableWhite;
    ImageButton[][] buttons;
    ImageButton.ImageButtonStyle style;
    Image[][] images;
    int row = 0;
    int col = 0;

    public Grid(int gridWidth, int gridHeight, float tileWidth, float tileHeight, Stage stage, Model model) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.stage = stage;
        this.model = model;

        textureBlack = new Texture("cell_black.png");
        textureWhite = new Texture("cell_white.png");
        regionBlack = new TextureRegion(textureBlack, 55, 55);
        regionWhite = new TextureRegion(textureWhite, 55, 55);
        drawableBlack = new TextureRegionDrawable(regionBlack);
        drawableWhite = new TextureRegionDrawable(regionWhite);
        style = new ImageButton.ImageButtonStyle();
        style.imageUp = drawableBlack;
        style.imageDown = drawableWhite;


        /*
        textures = new Texture[gridHeight][gridWidth];
        regions = new TextureRegion[gridHeight][gridWidth];
        drawables = new TextureRegionDrawable[gridHeight][gridWidth];
*/

        buttons = new ImageButton[gridHeight][gridWidth];
        images = new Image[gridHeight][gridWidth];

        createGrid();
    }

    /**
     * creates the view for the cells with all cells in the black color
     */
    private void createGrid() {
        Image current;

        for (row = 0; row < gridHeight; ++row) {
            for (col = 0; col < gridWidth; ++col) {
                current = images[row][col];

                images[row][col] = new Image(drawableBlack);
                images[row][col].setPosition(col*tileWidth, stage.getHeight() - ((row+1)*tileHeight));

                current = images[row][col];
                current.addListener(new MyListener(current, row, col));
            }
        }
    }

    /**
     * listener for the cells
     */
    public class MyListener extends InputListener {
        private Actor actor;
        private int row;
        private int col;

        public MyListener(Actor actor, int row, int col) {
            super();
            this.actor = actor;
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

            toggleBlackWhite((Image)actor);
            model.getMatrix().getCells()[row][col].toggleState();

            return true;
        }
    }

    /**
     * sets one cell black
     * @param row
     * @param col
     */
    public void setBlack(int row, int col) {
        images[row][col].setDrawable(drawableBlack);
    }

    /**
     * sets one cell white
     * @param row
     * @param col
     */
    public void setWhite(int row, int col) {
        images[row][col].setDrawable(drawableWhite);
    }

    /**
     * toggles the color of a cell
     * @param image
     */
    public void toggleBlackWhite(Image image) {
        if (image.getDrawable().equals(drawableBlack)) {
            image.setDrawable(drawableWhite);
        } else {
            image.setDrawable(drawableBlack);
        }
    }

    /**
     * resetting the view
     */
    public void reset() {
        for (row = 0; row < gridHeight; ++row) {
            for (col = 0; col < gridWidth; ++col) {
                setBlack(row, col);
            }
        }
    }

    public float getTileHeight() {
        return tileHeight;
    }

    public float getTileWidth() {
        return tileWidth;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public Stage getStage() {
        return stage;
    }

    public Texture getTextureBlack() {
        return textureBlack;
    }

    public Texture getTextureWhite() {
        return textureWhite;
    }

    public TextureRegion getRegionWhite() {
        return regionWhite;
    }

    public TextureRegion getRegionBlack() {
        return regionBlack;
    }

    public TextureRegionDrawable getDrawableBlack() {
        return drawableBlack;
    }

    public TextureRegionDrawable getDrawableWhite() {
        return drawableWhite;
    }

    public ImageButton[][] getButtons() {
        return buttons;
    }

    public ImageButton.ImageButtonStyle getStyle() {
        return style;
    }

    public Image[][] getImages() {
        return images;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
