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
            }
        }
        this.view = view;
    }

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

    public void step() {
        /*
         1.Eine tote Zelle mit genau drei lebenden Nachbarn wird in der Folgegeneration neu geboren.
         2.Lebende Zellen mit weniger als zwei lebenden Nachbarn sterben in der Folgegeneration an Einsamkeit.
         3.Eine lebende Zelle mit zwei oder drei lebenden Nachbarn bleibt in der Folgegeneration am Leben.
         4.Lebende Zellen mit mehr als drei lebenden Nachbarn sterben in der Folgegeneration an Überbevölkerung.
         */
        // Todo: View ändern bei Änderung des Modells

        /*
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                System.out.print(cells[row][col].isAlive());
            }
            System.out.println("");
        }
*/

        Cell current;
        newCells = cells.clone();
        int neighborsAlive = 0;

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                current = newCells[row][col];
                neighborsAlive = neighborsAlive(row, col);

                if (cells[row][col].isAlive()) {
                    if (neighborsAlive < 2) {
                        current.setDead();
                        view.getGrid().setBlack(row, col);
                    } else if ((neighborsAlive == 2) || (neighborsAlive == 3)) {
                        current.setAlive();
                        view.getGrid().setWhite(row, col);
                    } else {
                        current.setDead();
                        view.getGrid().setBlack(row, col);
                    }

                } else {
                    if (neighborsAlive == 3) {
                        current.setAlive();
                        view.getGrid().setWhite(row, col);
                    }
                }
            }
        }
        cells = newCells;
    }

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
