package Model;

public class Model {
    private Matrix matrix;

    public Model(Matrix matrix) {
        this.matrix = matrix;
    }

    public void step() {
        matrix.step();
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
