package com.haol.gameoflife.model;

import com.haol.gameoflife.view.View;

public class Model {
    private Matrix matrix;
    private View view;

    public Model(int height, int width, View view) {
        matrix = new Matrix(height, width, view);
        this.view = view;
    }

    public Model(Matrix matrix) {
        this.matrix = matrix;
    }

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
}
