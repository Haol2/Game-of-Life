package com.haol.gameoflife.Model;

public class Cell {
    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setAlive() {
        isAlive = true;
    }

    public void setDead() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
