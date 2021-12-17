package com.haol.gameoflife.model;

import com.haol.gameoflife.view.View;

public class Matrix {
    private Cell[][] cells;
    private Cell[][] newCells;
    private View view;

    public Matrix(int width, int height, View view) {
        cells = new Cell[height][width];
        newCells = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                cells[row][col] = new Cell(false);
                newCells[row][col] = new Cell(false);
            }
        }
        this.view = view;
    }

    /**
     *
     * @param row
     * @param col
     * @return number of neighbors of a cell that are alive
     */
    public int neighborsAlive(int row, int col) {
        int n = 0;

        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <= col+1; j++) {
                if (!(i < 0) && !(j < 0)) {
                    if(!(i >= cells.length) && !(j >= cells[0].length)) {
                        if (!(i == row && j == col)) {
                            if (cells[i][j].isAlive()) {
                                n++;
                            }
                        }
                    }
                }
            }
        }
        return n;
    }

    /**
     * calculates the next state of the cells and changes colors accordingly
     */
    public void step() {
        /*
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                System.out.print(cells[row][col].isAlive());
            }
            System.out.println("");
        }
*/
        int neighborsAlive = 0;

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                neighborsAlive = neighborsAlive(row, col);

                if (evaluateCell(cells[row][col].isAlive(), neighborsAlive)) {
                    newCells[row][col].setAlive();
                } else {
                    newCells[row][col].setDead();
                }
            }
        }

        cells = newCells;
        setColors(cells);
    }

    /**
     *
     * @param isAlive
     * @param neighborsAlive
     * @return true if cell will be alive and false if cell will be dead in the next generation
     */
    private boolean evaluateCell(boolean isAlive, int neighborsAlive) {
        if (isAlive && neighborsAlive <= 1) return false; // Lonely
        if (isAlive && neighborsAlive >= 2 && neighborsAlive <= 3) return true; // Lives
        if (isAlive && neighborsAlive >= 4 && neighborsAlive <= 8) return false; // Overcrowded

        if (!isAlive && neighborsAlive == 3) return true; // Birth
        if (!isAlive && neighborsAlive != 3) return false; // Barren
        return false;
    }

    /**
     * set colors according to cells
     * @param cells
     */
    private void setColors(Cell[][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if (cells[row][col].isAlive()) {
                    view.getGrid().setWhite(row, col);
                } else {
                    view.getGrid().setBlack(row, col);
                }
            }
        }
    }

    /**
     * resetting the cells
     */
    public void reset() {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                cells[row][col].setDead();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}
