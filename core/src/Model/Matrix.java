package Model;

import java.util.ArrayList;

public class Matrix {
    private ArrayList<ArrayList<Cell>> cells;

    public Matrix(int x, int y) {
        cells = new ArrayList<ArrayList<Cell>>(y);
        for (ArrayList<Cell> i : cells) i = new ArrayList<Cell>(x);
    }

    public int neighborsAlive(int x, int y) {
        int n = 0;
        int sizex = cells.get(0).size();
        int sizey = cells.size();

        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (!(i < 0 && j < 0 && i > sizex-1 && j > sizey-1)) {
                    if (!(i == x && j == y)) {
                        if (cells.get(j).get(i).isAlive()) n++;
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
        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; i < cells.get(0).size(); j++) {
                current = cells.get(i).get(j);
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
    }

    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }
}
