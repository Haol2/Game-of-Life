package Model;

import java.util.ArrayList;

public class Matrix {
    private ArrayList<ArrayList<Cell>> cells;

    public Matrix(int x, int y) {
        cells = new ArrayList<ArrayList<Cell>>(x);
        for (ArrayList<Cell> i : cells) i = new ArrayList<Cell>(y);
    }

    public int neighborsAlive(int x, int y) {
        int n = 0;
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.get(0).size(); ++j) {
                if (Math.abs(x-i) < 2 && Math.abs(y-j) < 2) {
                    if (!(i == x && j == y)) {
                        if (cells.get(i).get(j).isAlive()) ++n;
                    }
                }
            }
        }
        return n;
    }

    public void step() {
        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; i < cells.get(0).size(); j++) {
                
            }
        }
    }
    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }
}
