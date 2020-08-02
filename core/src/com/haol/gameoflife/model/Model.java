package com.haol.gameoflife.model;

import com.haol.gameoflife.view.View;

public class Model {
    private Matrix matrix;
    private View view;

    public Model(int width, int height, View view) {
        matrix = new Matrix(width, height, view);
        this.view = view;
    }

    public Model(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * executes a step for amount times
     * @param amount
     */
    public void step(int amount) {
        int i = 0;
        while (i < amount) {
            matrix.step();
            i++;
        }
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    /**
     * resetting the model
     */
    public void reset() {
        this.matrix.reset();
    }
}
