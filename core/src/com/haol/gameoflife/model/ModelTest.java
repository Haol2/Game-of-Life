package com.haol.gameoflife.model;

public class ModelTest {
    private Matrix matrix;
    private Cell calive = new Cell(true);
    private Cell cdead = new Cell(false);

    public ModelTest(Matrix matrix) {
        this.matrix = matrix;
    }

    /*
    public void test() {
        matrix.reset();
        matrix.getCells()[1][1] = new Cell(true);
        matrix.step();
        String t1 = "Test 1 " + matrix.getCells().equals() ? "passed" : "failed";
        System.out.println(t1);

        matrix.reset();
        matrix.getCells()
        matrix.step();
        String t2 = "Test 2 " + matrix.getCells().equals() ? "passed" : "failed";
        System.out.println(t2);

        matrix.reset();
        matrix.getCells()
        matrix.step();
        String t3 = "Test 3 " + matrix.getCells().equals() ? "passed" : "failed";
        System.out.println(t3);

        matrix.reset();
        matrix.getCells()
        matrix.step();
        String t4 = "Test 4 " + matrix.getCells().equals() ? "passed" : "failed";
        System.out.println(t4);
    }*/
}
