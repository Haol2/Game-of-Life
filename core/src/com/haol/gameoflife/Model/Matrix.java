package com.haol.gameoflife.Model;

import java.util.ArrayList;

public class Matrix {
    private Cell[][] cells;

    public Matrix(int x, int y) {
        cells = new Cell[y][x];
    }

    public int neighborsAlive(int x, int y) {
        int n = 0;

        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (!(i < 0 && j < 0 && i > cells[0].length-1 && j > cells.length-1)) {
                    if (!(i == x && j == y)) {
                        if (cells[j][i].isAlive()) n++;
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
        Cell current;
        Cell[][] newCells = cells;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; i < cells[0].length; j++) {
                current = newCells[j][i]);
                switch (neighborsAlive(i, j)) {
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

    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }
}
