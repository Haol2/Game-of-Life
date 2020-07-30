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
    /*
    Texture[][] textures;
    TextureRegion[][] regions;
    TextureRegionDrawable[][] drawables;
    */
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



    private void createGrid() {
        Image current;

        for (row = 0; row < gridHeight; ++row) {
            for (col = 0; col < gridWidth; ++col) {
                /*
                    textures[j][i] = new Texture("cell_black.png");
                    regions[j][i] = new TextureRegion(textures[j][i], 55, 55);
                    drawables[j][i] = new TextureRegionDrawable(regions[j][i]);
                    */

                /*
                    buttons[row][col] = new ImageButton(drawableWhite);
                    buttons[row][col].setPosition(col*tileWidth, row*tileHeight);
                    buttons[row][col].setStyle(style);
                    System.out.println(col*tileWidth + ", " + row*tileHeight);
                    buttons[row][col].addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            ((ImageButton)event.getRelatedActor()).toggle();
                        }
                    });
*/
                current = images[row][col];
                images[row][col] = new Image(drawableBlack);
                //images[row][col].setPosition(col*tileWidth, row*tileHeight);
                images[row][col].setPosition(col*tileWidth, stage.getHeight() - ((row+1)*tileHeight));
                //System.out.println(col*tileWidth + ", " + row*tileHeight);
                current = images[row][col];
                current.addListener(new MyListener(current, row, col));

                /*
                images[row][col].addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                        System.out.println(current);
                    }
                });
*/

                /*
                images[row][col].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        System.out.println("Typ: " + event.getType());
                        System.out.println("Dieser Actor ist: " + event.getRelatedActor());
                        System.out.println("Und als Image: " + (Image)(event.getRelatedActor()));
                        //((Image)event.getRelatedActor()).setDrawable(drawableWhite);
                        return true;
                    }
                });
                */

                    //table.add(buttons[j][i]);
            }
            //table.row();
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

    public void setBlack(int row, int col) {
        images[row][col].setDrawable(drawableBlack);
    }

    public void setWhite(int row, int col) {
        images[row][col].setDrawable(drawableWhite);
    }

    public void toggleBlackWhite(Image image) {
        if (image.getDrawable().equals(drawableBlack)) {
            image.setDrawable(drawableWhite);
        } else {
            image.setDrawable(drawableBlack);
        }
    }

    public void reset() {
        for (row = 0; row < gridHeight; ++row) {
            for (col = 0; col < gridWidth; ++col) {
                setBlack(row, col);
            }
        }
    }

}
