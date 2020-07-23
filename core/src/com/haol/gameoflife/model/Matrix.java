package com.haol.gameoflife.model;

import com.haol.gameoflife.view.View;

public class Matrix {
    private Cell[][] cells;
    private Cell[][] newCells;
    private View view;

    public Matrix(int height, int width, View view) {
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
                            if (cells[row][col].isAlive()) n++; //indexoutofBoudn
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
        Cell current;
        newCells = cells.clone();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                current = newCells[row][col];
                switch (neighborsAlive(row, col)) {
                    case 0:
                    case 1:
                        current.setDead();
                        break;
                    case 2:
                        break;
                    case 3:
                        if (!current.isAlive()) {
                            current.setAlive();
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        if (current.isAlive()) {
                            current.setDead();
                        }
                        break;
                }
            }
        }
        cells = newCells;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
